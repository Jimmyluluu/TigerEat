package com.example.tigereatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchAdapter extends BaseAdapter {

    private Context context;
    private final String[] names;
    private final int[] images;


    public SearchAdapter(Context context, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() { return names.length; }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        // Context 動態放入mainActivity
        LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            grid = new View(context);
            // 將grid_single 動態載入(image+text)
            grid = layoutInflater.inflate(R.layout.search_layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.tvName);
            ImageView imageView = (ImageView) grid.findViewById(R.id.sImg);
            textView.setText(names[position]);
            imageView.setImageResource(images[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}
