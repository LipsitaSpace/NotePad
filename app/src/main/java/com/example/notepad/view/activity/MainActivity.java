package com.example.notepad.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.view.adapter.NotesAdapter;
import com.example.notepad.viewmodel.NotesViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ImageButton addBtn;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initializeListener();
        NotesViewModel notesViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(NotesViewModel.class);
        notesViewModel.getAllNotes().observe(this, adapter::setNotes);

    }
    public void initViews(){
        recyclerView = findViewById(R.id.notesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter();
        recyclerView.setAdapter(adapter);

        addBtn = findViewById(R.id.addButton);

    }
    public void initializeListener(){
        addBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddNotesActivity.class));
        });
    }
}
