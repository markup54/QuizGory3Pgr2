package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button sprawdzButton;
    Button podpowiedzButton;
    RadioGroup odpowiedziRadioGroup;
    TextView pytanieTextView;
    RadioButton odpaRadioButton;
    RadioButton odpbRadioButton;
    RadioButton odpcRadioButton;
    ImageView imageView;
    ArrayList<Pytanie> pytanka;
    int liczbaPunktow = 0;
    int aktualnyIndeks =0;//będzie zerem piszemy dla przejrzystości:)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pytanieTextView = findViewById(R.id.textViewPytanie);
        odpaRadioButton = findViewById(R.id.radioButton);
        odpbRadioButton = findViewById(R.id.radioButton2);
        odpcRadioButton = findViewById(R.id.radioButton3);
        imageView = findViewById(R.id.imageView);
        
        Pytanie.przygotujPytania();
        pytanka = Pytanie.pytaniaArrayList;
        wypelnijWidokiPytaniem(aktualnyIndeks);
        int kodPodpowiedzi = 0;
        sprawdzButton = findViewById(R.id.button);
        sprawdzButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            //zliczanie punktow
                        if(sprawdz(pytanka.get(aktualnyIndeks).getOdpowiedz()))
                            liczbaPunktow++;

                            aktualnyIndeks++;
                            if(aktualnyIndeks==pytanka.size()) {
                                Toast.makeText(MainActivity.this,
                                        "Koniec testu, zdobyto "+liczbaPunktow,
                                        Toast.LENGTH_SHORT).show();
                                aktualnyIndeks --;
                            } //TODO widok z zakonczeniem testu
                            wypelnijWidokiPytaniem(aktualnyIndeks);

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
                //TODO przekazać w intencji jakie pytanie
                intencja.putExtra("Index",aktualnyIndeks);
                liczbaPunktow--;
                int requestCode = 0;
                startActivityForResult(intencja,requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK ){
            liczbaPunktow--;
        }
    }

    private boolean sprawdz(int numerOdpowiedzi){
        RadioButton[] radioButtony =
                new RadioButton[] {odpaRadioButton,odpbRadioButton,odpcRadioButton};
        for (int i =0 ;i<radioButtony.length;i++) {
            if(radioButtony[i].isChecked())
                if(i == numerOdpowiedzi)
                    return true;
                else
                    return false;
        }
        return false;
    }

    void wypelnijWidokiPytaniem(int i){
        Pytanie aktualnePytanie = pytanka.get(i);
        pytanieTextView.setText(aktualnePytanie.getTresc());
        odpaRadioButton.setText(aktualnePytanie.getOdpowiedzi().get(0));
        odpbRadioButton.setText(aktualnePytanie.getOdpowiedzi().get(1));
        odpcRadioButton.setText(aktualnePytanie.getOdpowiedzi().get(2));
        imageView.setImageResource(aktualnePytanie.getIdObrazka());
        imageView.setContentDescription("Jakaś podpowiedź");//TODO poprawić
        odpaRadioButton.setChecked(false);
        odpbRadioButton.setChecked(false);
        odpcRadioButton.setChecked(false);
    }
}