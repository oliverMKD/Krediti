package com.oliver.krediti.klasi;

import java.io.Serializable;

public class Krediti implements Serializable {

    public String naziv;

    public Krediti() {
    }

    public Krediti(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
