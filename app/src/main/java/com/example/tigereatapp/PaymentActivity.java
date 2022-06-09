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
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment );
        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        bt1 = (Button) findViewById(R.id.cashPayment);
    }



    protected void cashPay(Bundle savedInstanceState) {
        //創建監聽器 綁定Button資源
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        bt1 = (Button) findViewById(R.id.cashPayment);
        //設置Button監聽
        bt1.setOnClickListener(new MyButtonListener());
    }

    //實現監聽器(需要導入android.view.View和android.content.Intent)
    // 實現OnClickListener接口
    private class MyButtonListener implements View.OnClickListener {
        @Override

        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "已選擇現金交易", Toast.LENGTH_LONG).show();

            Intent intent = new Intent();
            intent.setClass(PaymentActivity.this, ShoppingcartActivity.class);//從MainActivity頁面跳轉至LoginActivity頁面
            startActivity(intent);
            PaymentActivity.this.finish();
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
        }

    }

    protected void backToCart(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
    }

}