package com.example.newsapp.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun String.toDate(): String {
    try {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ss'Z'")
        val dateTime = LocalDateTime.parse(this, formatter)
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    } catch (e: Exception) {
        Log.d("TAG", "toDate: ${e.message}")
    }
    return this
}