package com.example.tigereatapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity{
    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;
    private Button mobilePayment;
    private Button cashPayment;
    private Button cencel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment );
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        cashPayment = (Button) findViewById(R.id.cashPayment);
        mobilePayment = (Button) findViewById(R.id.mobilePayment);
        cencel = (Button) findViewById(R.id.button3);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        cashPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        cashPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        cashPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "已選擇現金交易", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(
                        PaymentActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        mobilePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, MobilePayActivity.class);
                startActivity(intent);
            }
        });
        cencel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PaymentActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
    }



    protected void backToCart(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
    }

}