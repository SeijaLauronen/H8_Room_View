package com.example.ssl_h8_roomview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentTransaction;

//9.3.2020 tähän piti laittaa tuo implements fragmentti interface, jotta saa buttonin painalluksen
//No eipä auta, kaatuu napin painalluksesta. Ahaa, fragmenttiin piti tehdä pari juttua!!
public class MainActivity extends AppCompatActivity implements Fragmentti1.IFragmentti1 {

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
    @Override
    public void onButtonPressed(CharSequence input) { //10.3.2020 lisäsin tuon inputin tuohon
        Toast.makeText(getApplicationContext(), input, Toast.LENGTH_LONG).show();
        //String textToSave = inputti pitääkö tämän tulla fragmentin interfacessa
    }
}
