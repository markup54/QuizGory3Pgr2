package com.example.myapplication;

import java.util.ArrayList;

public class Pytanie {
    private  String tresc;
    private  int idObrazka;
    private ArrayList<String> odpowiedzi;
    private int odpowiedz;
    private String podpowiedz;

    public Pytanie(String tresc, int idObrazka, ArrayList<String> odpowiedzi, int odpowiedz, String podpowiedz) {
        this.tresc = tresc;
        this.idObrazka = idObrazka;
        this.odpowiedzi = odpowiedzi;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }

    public ArrayList<String> getOdpowiedzi() {
        return odpowiedzi;
    }

    public void setOdpowiedzi(ArrayList<String> odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }

    public int getOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(int odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public void setPodpowiedz(String podpowiedz) {
        this.podpowiedz = podpowiedz;
    }
}
