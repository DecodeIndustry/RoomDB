package com.example.roomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class StudentModel(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int

)
