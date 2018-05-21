package com.oliver.krediti.klasi;

import java.io.Serializable;

public class NLB implements Serializable {

    public String auto;
    public String depozit;
    public String hipotek;
    public String potr;
    public String stanben;
    public String pederski;


    public String getPederski() {
        return pederski;
    }

    public void setPederski(String pederski) {
        this.pederski = pederski;
    }

    public NLB(String auto, String depozit, String hipotek, String potr, String stanben, String pederski) {
        this.auto = auto;
        this.depozit = depozit;
        this.hipotek = hipotek;
        this.potr = potr;
        this.stanben = stanben;
        this.pederski = pederski;

    }

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

    public NLB() {
    }
}
