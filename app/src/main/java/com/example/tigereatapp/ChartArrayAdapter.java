/*package com.example.tigereatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChartArrayAdapter extends ArrayAdapter<ChartLayout> {

    private Context context;
    private List<ChartLayout> chartLayouts;


    public ChartArrayAdapter(@NonNull Context context, int resource, @NonNull List<ChartLayout> chartLayouts) {
        super(context, resource, chartLayouts);
        this.context = context;
        this.chartLayouts = chartLayouts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout itemLayout = null;

        if (convertView == null) {
            itemLayout = (LinearLayout) inflater.inflate(R.layout.list_layout, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }


        return super.getView(position, convertView, parent);
    }
}
*/