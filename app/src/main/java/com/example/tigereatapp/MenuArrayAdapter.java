package com.example.tigereatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MenuArrayAdapter extends ArrayAdapter<Menu> {

    private Context context;
    private List<Menu> menus;

    public MenuArrayAdapter(@NonNull Context context, int resource, @NonNull List<Menu> menus) {
        super(context, resource, menus);
        this.context = context;
        this.menus = menus;
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

        Menu item = menus.get(position);

        ImageView iv = itemLayout.findViewById(R.id.foodPhoto);
        iv.setImageResource(item.getImg());

        TextView tvPlace = itemLayout.findViewById(R.id.foodName);
        tvPlace.setText(item.getName());

        TextView tvDate = itemLayout.findViewById(R.id.foodMoney);
        tvDate.setText(item.getMoney());

        Button tvJoin = itemLayout.findViewById(R.id.join);
        return itemLayout;

    }
}
