package com.example.notepad.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.model.Items;
import com.example.notepad.viewmodel.NotesViewModel;

import java.util.List;
public class MainActivity extends AppCompatActivity {
    private NotesViewModel notesViewModel;
    private NotesAdapter notesAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesAdapter = new NotesAdapter(null);
        recyclerView.setAdapter(notesAdapter);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        notesViewModel.getTaskList().observe(this, new Observer<List<Items>>() {
            @Override
            public void onChanged(List<Items> items) {
                notesAdapter.setNoteList(items);
            }
        });
    }
}
