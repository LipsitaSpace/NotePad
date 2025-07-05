package com.example.notepad.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.model.Items;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{

        private List<Items> noteList;

        public NotesAdapter(List<Items> noteList) {
            this.noteList= noteList;
        }

        public void setNoteList(List<Items> items) {
            this.noteList = items;
        }

        @NonNull
        @Override
        public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_notes, parent, false);
            return new NotesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
            holder.titelText.setText(noteList.get(position).getTitle());
            holder.descriptionText.setText(noteList.get(position).getDescription());
            holder.dateText.setText(noteList.get(position).getDate());
            holder.timeText.setText(noteList.get(position).getTime());
        }

        @Override
        public int getItemCount() {
            return noteList == null ? 0 : noteList.size();
        }

        static class NotesViewHolder extends RecyclerView.ViewHolder {
            TextView titelText;
            TextView descriptionText;
            TextView dateText;
            TextView timeText;

            NotesViewHolder(@NonNull View itemView) {
                super(itemView);
                titelText = itemView.findViewById(R.id.textViewTitle);
                descriptionText = itemView.findViewById(R.id.textViewDescription);
                dateText = itemView.findViewById(R.id.textViewDate);
                timeText = itemView.findViewById(R.id.textViewTime);
            }
        }
}
