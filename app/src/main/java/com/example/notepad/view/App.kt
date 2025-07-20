package com.example.notepad.view

import android.R.attr.apiKey
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity

object App {
    var application: Context? = null
    val executors = AppExecutors()

    fun init(context: Context) {
        application = context
    }

}