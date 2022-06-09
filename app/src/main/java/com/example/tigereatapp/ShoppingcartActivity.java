package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingcartActivity extends AppCompatActivity {
    String meal = "餐點一";
    String serving = "共 1 份";
    String money = "100 元";
    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;

    //店名
    private String[] shopName =  {"紅茶","綠茶"};
    //運費
    private String[] shopstrings =  {"1","1"};
    //運送時間
    private String[] shopMoney =  {"40","40"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart );
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        TextView txv = findViewById(R.id.shop);

        ShoppingArrayAdapter adapter;
        adapter = new ShoppingArrayAdapter(ShoppingcartActivity.this, shopName, shopstrings, shopMoney);
        ListView grid = (ListView) findViewById(R.id.listview);
        grid.setAdapter(adapter);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ShoppingcartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ShoppingcartActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ShoppingcartActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ShoppingcartActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}