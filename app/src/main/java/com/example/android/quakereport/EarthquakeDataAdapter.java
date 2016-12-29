package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lawrey on 29/12/16.
 */

public class EarthquakeDataAdapter extends ArrayAdapter<Earthquake> {

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
        magTextView.setText(Double.toString(currentEarthquakeData.getMag()));

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(currentEarthquakeData.getPlace());

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(unixTimeToPrettyDate(currentEarthquakeData.getTime()));

        return listItemView;
    }

    private String unixTimeToPrettyDate(long unixTimeInSeconds) {
        long dv = Long.valueOf(unixTimeInSeconds)*1000;// its need to be in milisecond
        Date df = new java.util.Date(dv);
        String vv = new SimpleDateFormat("MMM dd, yyyy").format(df);
        return vv;
    }
}
