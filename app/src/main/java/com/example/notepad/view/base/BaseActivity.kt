package com.example.notepad.view.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    abstract fun getContainerId(): Int
}