package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.renderscript.Sampler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Vaska on 29.8.2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<EarthquakeDetails> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeDetails> tEarthquakeDetails) {

        super (context, 0, tEarthquakeDetails);

        }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String getDistance (String placeObject) {

        String distanceSegment=placeObject;

        if (distanceSegment.contains("of"))
            distanceSegment = (placeObject.split(" of ")[0] + " of");
        else
            distanceSegment="Near of";

        return distanceSegment;
    }

    private String getPlace(String placeObject) {

        String placeSegment=placeObject;

        if (placeSegment.contains("of"))
            placeSegment = placeObject.split(" of ")[1];

        return placeSegment;
    }

    private int getMagnitudeColour (double magnitude){

        int magnitudeColour;
        int magnitudeCheck = (int) Math.floor(magnitude);
        switch (magnitudeCheck){

            case 0:
            case 1:
                magnitudeColour = R.color.magnitude1;
                break;
            case 2:
                magnitudeColour = R.color.magnitude2;
                break;
            case 3:
                magnitudeColour = R.color.magnitude3;
                break;
            case 4:
                magnitudeColour = R.color.magnitude4;
                break;
            case 5:
                magnitudeColour = R.color.magnitude5;
                break;
            case 6:
                magnitudeColour = R.color.magnitude6;
                break;
            case 7:
                magnitudeColour = R.color.magnitude7;
                break;
            case 8:
                magnitudeColour = R.color.magnitude8;
                break;
            case 9:
                magnitudeColour = R.color.magnitude9;
                break;
            default:
                magnitudeColour = R.color.magnitude10plus;
                break;

        }

        return ContextCompat.getColor(getContext(),magnitudeColour);
//        return magnitudeColour;
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


        TextView distanceTextView = (TextView) listItemView.findViewById(R.id.distance);
        String distance = getDistance(currentEarthquakeDetails.getPlace());
        distanceTextView.setText(distance);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place);
        String place = getPlace(currentEarthquakeDetails.getPlace());
        placeTextView.setText(place);

        Date dateObject = new Date (currentEarthquakeDetails.getTime());

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);


        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        int magnitudeColour = getMagnitudeColour(currentEarthquakeDetails.getMagnitude());


        magnitudeCircle.setColor(magnitudeColour);

////        time.setText(Double.toString(currentEarthquakeDetails.getTime()));
//        time.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentEarthquakeDetails.getTime()));




        return listItemView;
    }
}
