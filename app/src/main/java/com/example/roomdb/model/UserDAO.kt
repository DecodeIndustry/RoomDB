package com.example.roomdb.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:StudentModel)


    @Query("SELECT * FROM user_data")
    fun readAllData():LiveData<List<StudentModel>>

}