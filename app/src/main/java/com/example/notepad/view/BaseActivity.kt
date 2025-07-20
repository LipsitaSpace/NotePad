package com.example.notepad.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    abstract fun getContainerId(): Int
}