package com.example.android.quakereport;

/**
 * Created by Vaska on 29.8.2016.
 */
public class EarthquakeDetails {

    private double magnitude;
    private String place;
    private long time;
    String webLink;


    public EarthquakeDetails(double tMagnitude, String tPlace, long tTime, String tWebLink) {
        magnitude=tMagnitude;
        place=tPlace;
        time=tTime;
        webLink=tWebLink;

    }


    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace () {
        return place;
    }

    public long getTime () {
        return time;
    }

    public String getWebLink () {
        return webLink;
    }

}
