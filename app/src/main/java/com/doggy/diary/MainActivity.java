package com.doggy.diary;

import android.os.Bundle;

import com.doggy.diary.fragments.IndexFragment;
import com.doggy.diary.utils.FragmentHelper;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.doggy.diary.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FragmentHelper fragmentHelper;

    public MainActivity() {
        this.fragmentHelper = new FragmentHelper(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentHelper.change(new IndexFragment());
    }
}