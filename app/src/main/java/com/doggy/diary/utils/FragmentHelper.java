package com.doggy.diary.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.doggy.diary.R;

public class FragmentHelper {
    private final AppCompatActivity app;

    public FragmentHelper(AppCompatActivity app) {
        this.app = app;
    }

    public void change(Fragment fragment) {
        app.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_frame, fragment)
                .commit();
    }
}
