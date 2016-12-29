package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Lawrey on 29/12/16.
 */

public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mTime;
    private String mUrl;

    public Earthquake(double magnitude, String place, long time, String url) {
        this.mMagnitude = magnitude;
        this.mPlace = place;
        this.mTime = time;
        this.mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public long getTime() {
        return mTime;
    }

    public String getmUrl() {
        return mUrl;
    }
}
