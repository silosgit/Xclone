package com.xclone.xclone.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.xclone.xclone.RoomDB.TasksDao
import com.xclone.xclone.model.TaskModel

class RepositoryTask(private val taskDao: TasksDao) {

    val allTasks: LiveData<List<TaskModel>> = taskDao.getAllTasks()
    suspend fun  insert(task: TaskModel){
            taskDao.InsertTask(task)

    }


}

