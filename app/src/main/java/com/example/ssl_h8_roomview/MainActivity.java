package com.example.ssl_h8_roomview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.FragmenttiEKA,Fragmentti1.newInstance())
            .add(R.id.FragmenttiToka, Fragmentti2.newInstance())
            .commit();
    }
}
