package com.example.todo_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Fragment_one fragment = new Fragment_one();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.viweTaskFrameLayout,fragment).commit();


    }
}