package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {

    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;
    private int image[] = {R.drawable.rest1, R.drawable.rest2, R.drawable.rest3, R.drawable.rest4
            , R.drawable.rest5};
    private String[] name =  {"茶湯會", "鼎王", "瓦城", "烏龍麵所", "鼎泰豐"};
    GridView gridView = findViewById(R.id.gv);

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
    }
}