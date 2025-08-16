package com.xclone.xclone.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_tasks")
data class TaskModel(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "taskName") val taskName: String,
    @ColumnInfo(name = "dueDate") val dueDate: String,
    @ColumnInfo(name = "dueTime") val dueTime: String,
    @ColumnInfo(name = "isRepeatOn") val isRepeatOn: Boolean,
    @ColumnInfo(name = "parentListName") val parentListName: String
)
