//用來get 主要餐廳layout的變數
package com.example.tigereatapp;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeItem extends BaseAdapter {

    private final Context context;

    private final String[] resName;
    private final String[] resTime;
    private final String[] resFee;
    private final String[] resScore;
    private final int[] resImg;

    /*static class ViewHolder{
        LinearLayout rlBorder;
        TextView reName;
        TextView reFee;
        TextView reTime;
        TextView reScore;
        ImageView reImg;

    }*/

    //初始化
    public HomeItem(Context context, String[] resName, String[] resTime, String[] resFee, String[] resScore, int[] resImg) {
        this.context = context;
        this.resName = resName;
        this.resTime = resTime;
        this.resFee = resFee;
        this.resScore = resScore;
        this.resImg = resImg;
    }

    @Override
    public int getCount() {
        return resFee.length;
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
            girp = layoutInflater.inflate(R.layout.home_layout, null);
            TextView reName = (TextView) girp.findViewById(R.id.restName);
            TextView reFee = (TextView) girp.findViewById(R.id.restFee);
            TextView reTime = (TextView) girp.findViewById(R.id.restTime);
            TextView reScore = (TextView) girp.findViewById(R.id.reatScore);
            ImageView reImg = (ImageView) girp.findViewById(R.id.restImg);
            reName.setText(resName[position]);
            reFee.setText(resFee[position]);
            reTime.setText(resTime[position]);
            reScore.setText(resScore[position]);
            reImg.setImageResource(resImg[position]);
        } else {
            girp = (View) convertView;
        }
        return girp;
    }
}