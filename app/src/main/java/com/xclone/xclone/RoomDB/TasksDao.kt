package com.xclone.xclone.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xclone.xclone.model.TaskModel

@Dao
interface TasksDao {
    @Insert
   suspend fun InsertTask(task: TaskModel)
    @Delete
    suspend fun DeleteTask(task: TaskModel)

    @Update
    suspend fun UpdateTask(task: TaskModel)

    @Query("SELECT * FROM table_tasks")
    fun getAllTasks(): LiveData<List<TaskModel>>

}