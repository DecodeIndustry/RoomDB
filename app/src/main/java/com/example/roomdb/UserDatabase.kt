package com.example.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.model.StudentModel
import com.example.roomdb.model.UserDAO

@Database(entities = [StudentModel::class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao():UserDAO

    companion object{

        private var INSTANCE:UserDatabase? =null
        fun getDatabase (context:Context):UserDatabase{

            val tempIns = INSTANCE
            if (tempIns != null){
                return tempIns
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_data"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }

}