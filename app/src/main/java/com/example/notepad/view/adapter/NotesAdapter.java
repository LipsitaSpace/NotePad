package com.example.notepad.view.adapter;

import static com.example.notepad.utils.Helper.showMsg;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.model.Notes;
import com.example.notepad.view.fragment.NoteCreateFragment;
import com.example.notepad.viewmodel.NotesViewModel;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private List<Notes> noteList = new ArrayList<>();

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notes, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Notes notes = noteList.get(position);
        holder.title.setText(notes.title);
        holder.description.setText(notes.description);
        holder.date.setText(notes.date);
        holder.time.setText(notes.time);

        holder.itemView.setOnLongClickListener(v -> {
            NotesViewModel.delete(notes);
            noteList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, noteList.size());
            showMsg("Note Deleted");
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNotes(List<Notes> notes) {
        this.noteList = notes;
        notifyDataSetChanged();
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, date, time;

        NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            description = itemView.findViewById(R.id.textViewDescription);
            date = itemView.findViewById(R.id.textViewDate);
            time = itemView.findViewById(R.id.textViewTime);
        }
    }
}
