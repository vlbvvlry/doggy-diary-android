package com.doggy.diary.services;

import com.doggy.diary.network.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private final String URL = "http://192.168.50.93:80/";
    private final Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public API getApi() {
        return retrofit.create(API.class);
    }
}
