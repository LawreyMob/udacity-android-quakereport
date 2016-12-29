package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Lawrey on 29/12/16.
 */

public class Earthquake {

    private double mag;
    private String place;
    private long time;

    public Earthquake(double mag, String place, long time) {
        this.mag = mag;
        this.place = place;
        this.time = time;
    }

    public double getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public long getTime() {
        return time;
    }

}
