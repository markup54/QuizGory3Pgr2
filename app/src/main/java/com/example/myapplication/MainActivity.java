package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sprawdzButton;
    Button podpowiedzButton;
    RadioGroup odpowiedziRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sprawdzButton = findViewById(R.id.button);
        sprawdzButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(sprawdz()){
                            Toast.makeText(MainActivity.this,
                                    R.string.ok,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,
                                    R.string.no,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        podpowiedzButton = findViewById(R.id.button2);
        podpowiedzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencja = new Intent(MainActivity.this,
                        PodpowiedzActivity.class);
                //intencja jawna
                //wiadomo skąd dokąd
                startActivity(intencja);
            }
        });
    }
    private boolean sprawdz(){
        odpowiedziRadioGroup = findViewById(R.id.radioGroup);
        int idRadio = odpowiedziRadioGroup.getCheckedRadioButtonId();
        if(idRadio == R.id.radioButton2)
            return true;
        else
            return false;
    }
}