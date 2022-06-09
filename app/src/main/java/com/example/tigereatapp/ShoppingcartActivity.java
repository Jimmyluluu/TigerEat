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
    private Button goPayment;
    private Button order;
    //店名
    private String[] shopName =  {"紅茶", "奶茶"};
    //運費
    private String[] shopstrings =  {"1","1"};
    //money
    private String[] shopMoney =  {"40","40"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart );
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        goPayment = findViewById(R.id.goPayment);
        order = findViewById(R.id.order);

        TextView txv = findViewById(R.id.shop);
        TextView monenyTotal = findViewById(R.id.money_total);

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
        goPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ShoppingcartActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ShoppingcartActivity.this, ArrriveTimeActivity.class);
                startActivity(intent);
            }
        });
    }
}