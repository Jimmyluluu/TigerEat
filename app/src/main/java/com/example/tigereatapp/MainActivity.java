package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;
    public static final String SHOP_NO = "shop_no";
    //店名
    private String[] shopName =  {"茶湯會","鼎王","瓦城","烏龍麵所","鼎泰豐"};
    //運費
    private String[] shopFee =  {"15","15","20","10","45"};
    //運送時間
    private String[] shopTime =  {"15-20 分鐘","15-20 分鐘","25-30 分鐘","5-15 分鐘","35-45 分鐘"};
    //評價
    private String[] shopScore =  {"5","4.9","4.8","4.5","4"};
    //照片
    private int[] shopPhoto = {R.drawable.rest1, R.drawable.rest2, R.drawable.rest3,
            R.drawable.rest4, R.drawable.rest5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);


        HomeItem adapter;
        adapter = new HomeItem(MainActivity.this, shopName,  shopTime, shopFee, shopScore, shopPhoto);
        ListView grid = (ListView) findViewById(R.id.listview);
        grid.setAdapter(adapter);

        //處理onClick
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MealActivity.class);
                intent.putExtra(SHOP_NO, position);
                startActivity(intent);
            }
        });


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }
}