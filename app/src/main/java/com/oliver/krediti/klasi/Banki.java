package com.oliver.krediti.klasi;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Banki implements Parcelable {
    private String Max_iznos;

    public Banki(String max_iznos) {
        Max_iznos = max_iznos;
    }

    public Banki() {
    }

    public String getMax_iznos() {
        return Max_iznos;
    }

    public void setMaz_iznos(String max_iznos) {
        Max_iznos = max_iznos;
    }

    public static Creator<Banki> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Max_iznos);

    }


    protected Banki(Parcel in) {
        this.Max_iznos = in.readString();
    }

    public static final Parcelable.Creator<Banki> CREATOR = new Parcelable.Creator<Banki>() {
        @Override
        public Banki createFromParcel(Parcel source) {
            return new Banki(source);
        }

        @Override
        public Banki[] newArray(int size) {
            return new Banki[size];
        }
    };

}
