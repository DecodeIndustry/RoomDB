package com.example.roomdb.model

import androidx.lifecycle.LiveData

class UserRepository(private val userDao:UserDAO) {

    val readAllData :LiveData<List<StudentModel>> = userDao.readAllData()

    suspend fun addUser(user:StudentModel){
        userDao.addUser(user)
    }

}