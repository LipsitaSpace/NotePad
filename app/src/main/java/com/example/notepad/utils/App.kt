package com.example.notepad.utils

import android.content.Context

object App {
    var application: Context? = null
    val executors = AppExecutors()

    fun init(context: Context) {
        application = context
    }

}