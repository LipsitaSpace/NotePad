package com.example.notepad.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.model.Notes;
import com.example.notepad.viewmodel.NotesViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NotesAdapter adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);

        NotesViewModel notesViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(NotesViewModel.class);
        notesViewModel.getAllNotes().observe(this, adapter::setNotes);
        // Insert sample note
        notesViewModel.insert(new Notes("Meeting", "Project discussion", "2025-07-05", "10:00 AM"));
    }
}
