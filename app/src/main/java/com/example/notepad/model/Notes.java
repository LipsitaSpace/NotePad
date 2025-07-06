package com.example.notepad.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String description;
    public String date;
    public String time;

    public Notes(String title, String description, String date, String time) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }
}
