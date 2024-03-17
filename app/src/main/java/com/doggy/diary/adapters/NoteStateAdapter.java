package com.doggy.diary.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doggy.diary.R;
import com.doggy.diary.states.NoteState;

import java.util.List;

public class NoteStateAdapter extends RecyclerView.Adapter<NoteStateAdapter.ViewHolder> {

    private final List<NoteState> states;

    public NoteStateAdapter(List<NoteState> states) {
        this.states = states;
    }

    @NonNull
    @Override
    public NoteStateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.itemView.setOnClickListener(v -> {
            TextView textView = v.findViewById(R.id.item_note_filename);
            String filename = textView.getText().toString();
            Toast.makeText(v.getContext(), filename, Toast.LENGTH_SHORT).show();
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NoteStateAdapter.ViewHolder holder, int position) {
        NoteState state = states.get(position);
        holder.filename.setText(state.getFilename());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView filename;

        ViewHolder(View view) {
            super(view);
            filename = view.findViewById(R.id.item_note_filename);
        }
    }
}
