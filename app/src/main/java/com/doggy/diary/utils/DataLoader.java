package com.doggy.diary.utils;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doggy.diary.fragments.IndexFragment;
import com.doggy.diary.network.models.Note;
import com.doggy.diary.services.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataLoader {
    public void loadNotes(IndexFragment.Initer initer) {
        (new NetworkService())
                .getApi()
                .getNotes()
                .enqueue(new Callback<List<Note>>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<List<Note>> call,
                            @NonNull Response<List<Note>> response
                    ) {
                        System.out.println("SUCCESS");
                        assert response.body() != null;
                        initer.setStates(response.body()).init();
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<List<Note>> call,
                            @NonNull Throwable t
                    ) {
                        //t.printStackTrace();
                        //todo
                        t.printStackTrace();
                        System.out.println("ERROR");
                        System.out.println(t.getMessage());
                    }
                });
    }
}
