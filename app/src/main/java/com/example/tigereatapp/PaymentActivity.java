package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }
    protected void backToCart(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
    }
}