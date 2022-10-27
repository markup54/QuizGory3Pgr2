package com.example.myapplication;

import java.util.ArrayList;

public class Pytanie {
    private  int tresc;
    private  int idObrazka;
    private ArrayList<Integer> odpowiedzi;
    private int odpowiedz;
    private int podpowiedz;

    public static ArrayList<Pytanie> pytaniaArrayList;
    public static void przygotujPytania(){
        pytaniaArrayList = new ArrayList<>();
        pytaniaArrayList.add(new Pytanie(R.string.pytanie,
                R.drawable.tarnica, 1,R.string.opis,
                R.string.odp_a,R.string.odp_b,R.string.odp_c));
        pytaniaArrayList.add(new Pytanie(R.string.pytanie2,
                R.drawable.mnich, 2,R.string.opis2,
                R.string.odp_a2,R.string.odp_b2,R.string.odp_c2));
        pytaniaArrayList.add(new Pytanie(R.string.pytanie3,
                R.drawable.rysianka, 0,R.string.opis3,
                R.string.odp_a3,R.string.odp_b3,R.string.odp_c3));
        pytaniaArrayList.add(new Pytanie(R.string.pytanie4,
                R.drawable.stozek, 1,R.string.opis4,
                R.string.odp_a4,R.string.odp_b4,R.string.odp_c4));
    }


    public Pytanie(int tresc, int idObrazka, int odpowiedz,
                   int podpowiedz, int odpa,int odpb, int odpc) {
        this.tresc = tresc;
        this.idObrazka = idObrazka;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        this.odpowiedzi = new ArrayList<Integer>();
        this.odpowiedzi.add(odpa);
        this.odpowiedzi.add(odpb);
        this.odpowiedzi.add(odpc);
    }

    public int getTresc() {
        return tresc;
    }

    public void setTresc(int tresc) {
        this.tresc = tresc;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public ArrayList<Integer> getOdpowiedzi() {

        return odpowiedzi;
    }

    public void setOdpowiedzi(ArrayList<Integer> odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }

    public int getOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(int odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    public int getPodpowiedz() {
        return podpowiedz;
    }

    public void setPodpowiedz(int podpowiedz) {
        this.podpowiedz = podpowiedz;
    }
}
