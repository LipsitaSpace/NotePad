package com.example.notepad.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notepad.model.Notes;
import com.example.notepad.repository.NoteRepo;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    private NoteRepo repository;
    private LiveData<List<Notes>> allNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepo(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Notes notes) {
        repository.insert(notes);
    }

    public LiveData<List<Notes>> getAllNotes() {
        return allNotes;
    }

    public static void delete(Notes notes) {
        NoteRepo.delete(notes);
    }
}
