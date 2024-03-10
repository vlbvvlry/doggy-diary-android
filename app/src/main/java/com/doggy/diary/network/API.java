package com.doggy.diary.network;


import com.doggy.diary.network.models.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("/api/notes")
    Call<List<Note>> getNotes();

    @GET("api/note/{filename}")
    Call<Note> getNote(@Path("filename") String filename);
}
