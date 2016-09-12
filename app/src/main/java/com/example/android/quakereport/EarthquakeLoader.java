package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

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
        Log.v(LOG_TAG, "On Start Loading od Loaderot");
    }

    @Override
    public List<EarthquakeDetails> loadInBackground() {

        Log.v(LOG_TAG, "Load in background od Loaderot");

        if (mUrl == null)
            return null;

        List<EarthquakeDetails> earthquakes = QueryUtils.extractEarthquakes(mUrl);
        return earthquakes;
    }


}
