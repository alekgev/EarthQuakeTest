package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Vaska on 12.9.2016.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<EarthquakeDetails>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthquakeDetails> loadInBackground() {

        if (mUrl == null)
            return null;

        List<EarthquakeDetails> earthquakes = QueryUtils.extractEarthquakes(mUrl);
        return earthquakes;
    }


}
