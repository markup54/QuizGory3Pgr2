package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sprawdzButton;
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