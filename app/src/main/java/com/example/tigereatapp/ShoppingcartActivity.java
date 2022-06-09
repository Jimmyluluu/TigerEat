package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShoppingcartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart );
    }

    public void gotoPayment(View view) {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
    public void gotofinish(View view) {
        Intent intent = new Intent(this, ArrriveTimeActivity.class);
        startActivity(intent);
    }

}