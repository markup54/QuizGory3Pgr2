package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PodpowiedzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podpowiedz);
        int aktualnyIndeks = getIntent().getIntExtra("Index",0);
        Toast.makeText(PodpowiedzActivity.this,
                String.valueOf(aktualnyIndeks),
                Toast.LENGTH_SHORT)
                .show();
        ArrayList<Pytanie> pytanka = Pytanie.pytaniaArrayList;
        TextView textViewPytanie = findViewById(R.id.podpPytaniaTextView);
        textViewPytanie.setText(pytanka.get(aktualnyIndeks).getTresc());
        TextView textViewPodpowiedz = findViewById(R.id.podpowiedzTextView);
        textViewPodpowiedz.setText(pytanka.get(aktualnyIndeks).getPodpowiedz());
    }
}