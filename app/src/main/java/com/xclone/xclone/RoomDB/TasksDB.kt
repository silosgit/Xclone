package com.xclone.xclone.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xclone.xclone.model.TaskModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [TaskModel::class], version = 1)
abstract class TasksDb : RoomDatabase() {
    abstract fun taskDao(): TasksDao
    companion object{
        @Volatile
        private var INSTANCE: TasksDb? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): TasksDb{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    TasksDb::class.java,
                    "tasks_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}