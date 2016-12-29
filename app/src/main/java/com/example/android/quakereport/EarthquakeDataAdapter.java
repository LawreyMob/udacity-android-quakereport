package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lawrey on 29/12/16.
 */

public class EarthquakeDataAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeDataAdapter(Context context, int resource, List<Earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquakeData = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag_text_view);
        magTextView.setText(decimalToString(currentEarthquakeData.getMagnitude()));

        // Set the proper background color on the magnitude circle.

        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquakeData.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String offset = "", place = "";

        String[] fullPlaceString = currentEarthquakeData.getPlace().split(LOCATION_SEPARATOR);
        if(fullPlaceString.length>=2){
            offset = fullPlaceString[0] + LOCATION_SEPARATOR;
            place = fullPlaceString[1];
        }else{
            offset = getContext().getString(R.string.near_the);
            place = currentEarthquakeData.getPlace();
        }

        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_text_view);
        offsetTextView.setText(offset);

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(place);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(unixTimeToPrettyDate(currentEarthquakeData.getTime()));



        return listItemView;
    }

    private String decimalToString(double value) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output =formatter.format(value);
        return output;
    }

    private String unixTimeToPrettyDate(long unixTimeInSeconds) {
        Date df = new Date(unixTimeInSeconds);
        String dateToDisplay = new SimpleDateFormat("LLL dd, yyyy\nh:mm a").format(df);
        return dateToDisplay;
    }

    private int getMagnitudeColor(double magnitude) {

        int roundedDownMag = (int) Math.floor(magnitude);

        switch (roundedDownMag) {
            case 1 :
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2 :
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3 :
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4 :
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5 :
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6 :
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7 :
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8 :
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9 :
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            case 10 :
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            default :
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
        }

    }
}
