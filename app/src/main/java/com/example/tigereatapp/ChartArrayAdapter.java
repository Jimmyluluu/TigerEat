package com.example.tigereatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChartArrayAdapter extends ArrayAdapter<Chart> {

    private Context context;
    private List<Chart> charts;


    public ChartArrayAdapter(@NonNull Context context, int resource, @NonNull List<Chart> chartLayouts) {
        super(context, resource, chartLayouts);
        this.context = context;
        this.charts = chartLayouts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout itemLayout = null;

        if (convertView == null) {
            itemLayout = (LinearLayout) inflater.inflate(R.layout.chart_layout, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }

        Chart item = charts.get(position);

        ImageView iv = itemLayout.findViewById(R.id.img);
        iv.setImageResource(item.getImg());

        TextView tvPlace = itemLayout.findViewById(R.id.name);
        tvPlace.setText(item.getName());

        TextView tvDate = itemLayout.findViewById(R.id.score);
        tvDate.setText(item.getScore());

        return itemLayout;
    }
}
