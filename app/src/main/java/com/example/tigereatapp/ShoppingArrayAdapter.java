package com.example.tigereatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ShoppingArrayAdapter extends BaseAdapter {

    private final Context context;

    private final String[] resName;
    private final String[] resSuit;
    private final String[] resMoney;


    /*static class ViewHolder{
        LinearLayout rlBorder;
        TextView reName;
        TextView reFee;
        TextView reTime;
        TextView reScore;
        ImageView reImg;

    }*/

    //初始化
    public ShoppingArrayAdapter(Context context, String[] resName, String[] resSuit, String[] resMoney) {
        this.context = context;
        this.resName = resName;
        this.resSuit = resSuit;
        this.resMoney = resMoney;
    }

    @Override
    public int getCount() {
        return resSuit.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ViewHolder holder;
        View girp;
        LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            girp = new View(context);
            girp = layoutInflater.inflate(R.layout.shopping_car_layout, null);
            TextView reName = (TextView) girp.findViewById(R.id.meal);
            TextView reFee = (TextView) girp.findViewById(R.id.serving);
            TextView reTime = (TextView) girp.findViewById(R.id.meal_money);

            reName.setText(resName[position]);
            reFee.setText(resSuit[position]);
            reTime.setText(resMoney[position]);

        } else {
            girp = (View) convertView;
        }
        return girp;
    }
}
