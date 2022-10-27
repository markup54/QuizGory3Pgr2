package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button button1 = findViewById(R.id.button3);
        Button button = findViewById(R.id.pokazPodpowiedzButton);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textViewPodpowiedz.setVisibility(View.VISIBLE);
                        button.setVisibility(View.INVISIBLE);
                        button1.setVisibility(View.VISIBLE);

                    }
                }
        );

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencja = new Intent();
                setResult(RESULT_OK,intencja);
                finish();
            }
        });
    }
}