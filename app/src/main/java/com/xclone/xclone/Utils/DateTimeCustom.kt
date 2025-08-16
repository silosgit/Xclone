package com.xclone.xclone.Utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class DateTimeCustom {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate():String{
        val today = LocalDate.now()
        // format it (e.g., "16/08/2025")
        val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")
        val currentDay = today.format(formatter)
        return currentDay
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getTime():String{
        val now = LocalTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val currentTime = now.format(formatter)
        return currentTime
    }
}