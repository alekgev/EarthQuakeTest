package com.example.android.quakereport;

/**
 * Created by Vaska on 29.8.2016.
 */
public class EarthquakeDetails {

    private double magnitude;
    private String place;
    private String time;


    public EarthquakeDetails(double tMagnitude, String tPlace, String tTime) {
        magnitude=tMagnitude;
        place=tPlace;
        time=tTime;

    }


    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace () {
        return place;
    }

    public String getTime () {
        return time;
    }

}
