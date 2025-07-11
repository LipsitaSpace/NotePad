package com.example.notepad.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notepad.model.Notes;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Notes note);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    LiveData<List<Notes>> getAllNotes();
}
