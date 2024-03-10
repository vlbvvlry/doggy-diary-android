package com.doggy.diary.network.models;

import com.google.gson.annotations.SerializedName;

public class Note {

    @SerializedName("filename")
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
