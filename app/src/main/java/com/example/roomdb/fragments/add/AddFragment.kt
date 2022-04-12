package com.example.roomdb.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdb.R
import com.example.roomdb.model.StudentModel
import com.example.roomdb.model.UserViewModel


class AddFragment : Fragment() {


    lateinit var editFirstName:EditText
    lateinit var editLastName:EditText
    lateinit var editAge:EditText

    lateinit var addBtn:Button
    private lateinit var userViewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        editFirstName = view.findViewById(R.id.editName)
        editLastName = view.findViewById(R.id.editLatname)
        editAge = view.findViewById(R.id.editAge)
        addBtn = view.findViewById(R.id.addBtn)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        addBtn.setOnClickListener {

            addDataToDB()

        }

        return view
    }

    private fun addDataToDB() {

        val firstName = editFirstName.text.toString()
        val lastName = editLastName.text.toString()
        val age = editAge.text.toString()

        if (checkInput(firstName,lastName,age)){

            val user = StudentModel(0,firstName,lastName,Integer.parseInt(age.toString()))
            userViewModel.addUser(user)

            Toast.makeText(requireContext(),"Successfully Added",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),"Please Add All Fields ",Toast.LENGTH_SHORT).show()

        }

    }

    private fun checkInput(firstName:String,lastName:String,age:String):Boolean{

        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }

}