package com.doggy.diary.states;

public class NoteState {

    private String filename;

    public NoteState(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
