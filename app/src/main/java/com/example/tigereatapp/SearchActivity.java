package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;

    private int images[] = {R.drawable.rest1, R.drawable.rest2, R.drawable.rest3, R.drawable.rest4
            , R.drawable.rest5, R.drawable.rest6, R.drawable.rest7
            , R.drawable.rest8, R.drawable.rest9, R.drawable.rest10};
    private String[] names =  {"茶湯會", "鼎王", "瓦城", "烏龍麵所", "鼎泰豐", "公益麵攤", "肯德基"
            , "築間", "壽司郎", "翰林茶坊"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //bar
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SearchActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SearchActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SearchActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });


        SearchAdapter adapter = new SearchAdapter(SearchActivity.this, names, images);
        GridView grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);

    }


}