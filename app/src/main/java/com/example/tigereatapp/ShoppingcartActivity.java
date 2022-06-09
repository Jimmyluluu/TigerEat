package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
        Intent it = getIntent();
        String inp1 = it.getStringExtra("name1");
        String inp2 = it.getStringExtra("name2");
        String inp3 = it.getStringExtra("money1");
        String inp4 = it.getStringExtra("money2");
        //店名
        String[] shopName =  {inp1, inp2};
        //運費
        String[] shopstrings =  {"1","1"};
        //money
        String[] shopMoney =  {inp3, inp4};

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