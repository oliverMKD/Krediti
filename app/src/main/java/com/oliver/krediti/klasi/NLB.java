package com.oliver.krediti.klasi;

import java.io.Serializable;

public class NLB implements Serializable {

    String auto;
    String depozit;
    String hipotek;
    String potr;
    String stanben;

//    public NLB(String auto, String depozit, String hipotek, String potr, String stanben) {
//        this.auto = auto;
//        this.depozit = depozit;
//        this.hipotek = hipotek;
//        this.potr = potr;
//        this.stanben = stanben;
//    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getDepozit() {
        return depozit;
    }

    public void setDepozit(String depozit) {
        this.depozit = depozit;
    }

    public String getHipotek() {
        return hipotek;
    }

    public void setHipotek(String hipotek) {
        this.hipotek = hipotek;
    }

    public String getPotr() {
        return potr;
    }

    public void setPotr(String potr) {
        this.potr = potr;
    }

    public String getStanben() {
        return stanben;
    }

    public void setStanben(String stanben) {
        this.stanben = stanben;
    }
}
