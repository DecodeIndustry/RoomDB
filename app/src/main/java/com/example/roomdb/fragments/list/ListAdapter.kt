package com.example.roomdb.fragments.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.R
import com.example.roomdb.model.StudentModel

class ListAdapter(private var context:Context):RecyclerView.Adapter<ListAdapter.MyViewHoler>() {

    private var userLIst = emptyList<StudentModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoler {

        val itemVV = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
        return MyViewHoler(itemVV)

    }

    override fun onBindViewHolder(holder: MyViewHoler, position: Int) {

        var currentItem = userLIst[position]
        holder.showNum.setText(currentItem.id.toString())
        holder.firstName.setText(currentItem.firstName)
        holder.lastName.setText(currentItem.lastName)
        holder.age.setText(currentItem.age.toString())

    }

    override fun getItemCount(): Int {
        return userLIst.size
    }

    class MyViewHoler(view:View):RecyclerView.ViewHolder(view){


        val firstName:TextView = view.findViewById(R.id.firstNameTxt)
        val lastName:TextView = view.findViewById(R.id.lastNameTxt)
        val age:TextView = view.findViewById(R.id.ageTxt)
        val showNum:TextView = view.findViewById(R.id.dbIdTxt)
        val delImg:ImageView = view.findViewById(R.id.deleteImg)

    }

    fun setData(user:List<StudentModel>){

        this.userLIst = user
        notifyDataSetChanged()

    }

}