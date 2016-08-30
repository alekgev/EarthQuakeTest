package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vaska on 29.8.2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<EarthquakeDetails> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeDetails> tEarthquakeDetails) {

        super (context, 0, tEarthquakeDetails);

        }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.row_view, parent, false);
        }

        EarthquakeDetails currentEarthquakeDetails = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);

        magnitude.setText(Double.toString(currentEarthquakeDetails.getMagnitude()));

        TextView place = (TextView) listItemView.findViewById(R.id.place);

        place.setText(currentEarthquakeDetails.getPlace());

        TextView time = (TextView) listItemView.findViewById(R.id.time);

        time.setText(currentEarthquakeDetails.getTime());




        return listItemView;
    }
}
