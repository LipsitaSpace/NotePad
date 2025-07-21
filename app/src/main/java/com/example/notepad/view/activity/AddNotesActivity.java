package com.example.notepad.view.activity;

import android.os.Bundle;

import com.example.notepad.R;
import com.example.notepad.view.base.BaseActivity;
import com.example.notepad.view.fragment.NoteCreateFragment;

public class AddNotesActivity extends BaseActivity {
    @Override
    public int getContainerId() {
        return R.id.fragment_container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction()
                    .replace(getContainerId(), new NoteCreateFragment())
                    .commit();
    }
}
