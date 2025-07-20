package com.example.notepad.view;

import android.os.Bundle;

import com.example.notepad.R;

public class AddNotesActivity extends BaseActivity{
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
