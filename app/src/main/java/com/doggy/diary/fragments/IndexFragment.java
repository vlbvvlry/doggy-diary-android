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
import com.doggy.diary.services.NetworkService;
import com.doggy.diary.states.NoteState;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        loadNotes(view);
        recyclerInit(view);

        return view;
    }

    private void recyclerInit(View view) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        NoteStateAdapter esa = new NoteStateAdapter(states);
        RecyclerView rv = view.findViewById(R.id.notes_index);
        rv.setLayoutManager(llm);
        rv.setAdapter(esa);
    }

    private void loadNotes(View view) {
        (new NetworkService())
                .getApi()
                .getNotes()
                .enqueue(new Callback<List<Note>>() {
                    @Override
                    public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                        List<Note> notes =  response.body();
                        for (int i = 0; i < notes.size(); i++) {
                            states.add(new NoteState(notes.get(i).getFilename()));
                        }
                        recyclerInit(view);
                    }

                    @Override
                    public void onFailure(Call<List<Note>> call, Throwable t) {
                        //
                    }
                });
    }
}
