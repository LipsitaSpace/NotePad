package com.example.notepad.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notepad.model.Notes;

@Database(entities = {Notes.class}, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();

    private static NoteDataBase instance;

    public static synchronized NoteDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDataBase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
