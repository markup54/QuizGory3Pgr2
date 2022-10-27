package com.example.myapplication;

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

        sprawdzButton = findViewById(R.id.button);
        sprawdzButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(sprawdz(pytanka.get(aktualnyIndeks).getOdpowiedz())){
                            Toast.makeText(MainActivity.this,
                                    R.string.ok,
                                    Toast.LENGTH_SHORT).show();
                            aktualnyIndeks++;
                            if(aktualnyIndeks==pytanka.size())
                                aktualnyIndeks =0; //TODO widok z zakonczeniem testu
                            wypelnijWidokiPytaniem(aktualnyIndeks);
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
                //TODO przekazać w intencji jakie pytanie
                intencja.putExtra("Index",aktualnyIndeks);
                startActivity(intencja);
            }
        });
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