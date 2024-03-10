package com.doggy.diary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doggy.diary.R;
import com.doggy.diary.adapters.NoteStateAdapter;
import com.doggy.diary.network.models.Note;
import com.doggy.diary.states.NoteState;
import com.doggy.diary.utils.DataLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class IndexFragment extends Fragment {

    ArrayList<NoteState> states = new ArrayList<>();

    public IndexFragment() {
        super(R.layout.fragment_index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);

//        List<Note> notes = DataLoader.loadNotes();
//
//        //todo
//        // Fucking code. I sure that to do via other and better way.
//        for(int i = 0; i < notes.size(); i++) {
//            states.add(new NoteState(notes.get(i).getFilename()));
//        }

        Initer initer = new Initer(view, states, getActivity());
        initer.init();

        DataLoader dataLoader = new DataLoader();

        dataLoader.loadNotes(initer);


        return view;
    }

    //
    public static class Initer {
        private final View view;
        private final List<NoteState> states;
        private final FragmentActivity activity;

        public Initer(View view, List<NoteState> states, FragmentActivity activity) {
            this.view = view;
            this.states = states;
            this.activity = activity;
        }

        public  Initer setStates(List<Note> notes) {
            states.clear();

            for (int i = 0; i < notes.size(); i++) {
                states.add(new NoteState(notes.get(i).getFilename()));
            }

            return this;
        }

        public void init() {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            NoteStateAdapter noteStateAdapter = new NoteStateAdapter(states);
            RecyclerView recyclerView = view.findViewById(R.id.notes_index);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(noteStateAdapter);
        }
    }
}
