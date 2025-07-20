package com.example.notepad.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.notepad.R;
import com.example.notepad.model.Notes;
import com.example.notepad.viewmodel.NotesViewModel;

public class NoteCreateFragment extends Fragment {

    public EditText etTitle, etDescription;
    public Button btnSubmit;
    public NotesViewModel notesViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_create_fragment, container, false);
        initViews(view);
        btnSubmit.setOnClickListener(this::onClick);
        return view;
    }

    public void initViews(@NonNull View view) {
        etTitle = view.findViewById(R.id.et_title);
        etDescription = view.findViewById(R.id.et_description);
        btnSubmit = view.findViewById(R.id.btn_submit);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notesViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()))
                .get(NotesViewModel.class);
    }

    public void onClick(View view) {
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        notesViewModel.insert(new Notes(title, description, "2025-07-05", "10:00 AM"));
        if (getActivity() != null) {
            Helper.showMsg("Note Added Successfully");
            getActivity().finish();
        }
    }
}
