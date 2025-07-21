package com.example.notepad.utils;

import android.widget.Toast;

public class Helper {
    public static void showMsg(String msg){
        Toast.makeText(App.INSTANCE.getApplication(), msg, Toast.LENGTH_SHORT).show();
    }
}
