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

public class ShoppingCar extends ArrayAdapter<Shop> {
    private Context context;
    private List<Shop> shops;

    public ShoppingCar(@NonNull Context context, int resource, @NonNull List<Shop> shops) {
        super(context, resource);
        this.context = context;
        this.shops = shops;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout itemLayout = null;

        if (convertView == null) {
            itemLayout = (LinearLayout) inflater.inflate(R.layout.shop_list_layout, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }

        Shop item = shops.get(position);



        TextView tvPlace = itemLayout.findViewById(R.id.meal);
        tvPlace.setText(item.getName());

        TextView tvDate = itemLayout.findViewById(R.id.serving);
        tvDate.setText(item.getServing());

        TextView tvMoney = itemLayout.findViewById(R.id.meal_money);
        tvMoney.setText(item.getMoney());
        return itemLayout;
    }
}
