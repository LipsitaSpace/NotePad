package com.example.notepad.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notepad.db.NoteDao;
import com.example.notepad.db.NoteDataBase;
import com.example.notepad.model.Notes;

import java.util.List;

public class NoteRepo {
    private NoteDao noteDao;
    private LiveData<List<Notes>> allNotes;

    public NoteRepo(Application application) {
        NoteDataBase database = NoteDataBase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Notes note) {
        new Thread(() -> noteDao.insert(note)).start();
    }

    public static void delete(Notes notes) {
        new Thread(() -> NoteDataBase.getInstance(null).noteDao().delete(notes)).start();
    }

    public LiveData<List<Notes>> getAllNotes() {
        return allNotes;
    }
}
