package com.example.notepad.model;

public class Items {
    public String Title;
    public String Description;
    public String Date;
    public String Time;

    public Items(String title, String description, String date, String time) {
        Title = title;
        Description = description;
        Date = date;
        Time = time;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }
}
