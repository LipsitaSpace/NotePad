package com.example.notepad.view;

import android.app.Application;

public class MyApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        App.INSTANCE.init(this);
    }
}
