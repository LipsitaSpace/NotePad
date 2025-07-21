package com.example.notepad.data.dp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notepad.model.Notes;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Notes note);

    @Delete
    void delete(Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    LiveData<List<Notes>> getAllNotes();
}
