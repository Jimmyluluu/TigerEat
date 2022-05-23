package com.example.tigereatapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HomeArrayAdapter extends ArrayAdapter<HomeItem> {

    private Context context;
    private List<HomeItem> homeItems;


    public HomeArrayAdapter(@NonNull Context context, int resource,
                            @NonNull List<HomeItem> homeItems) {
        super(context, resource, homeItems);
        this.context = context;
        this.homeItems = homeItems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
