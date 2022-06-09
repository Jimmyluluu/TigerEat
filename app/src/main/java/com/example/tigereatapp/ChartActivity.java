//排行榜
package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    public static final String SHOP_NO = "shop_no";
    private Button Home;
    private Button Shop;
    private Button Search;
    private Button Set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Home = findViewById(R.id.Home);
        Shop = findViewById(R.id.Shopping);
        Search = findViewById(R.id.Search);
        Set = findViewById(R.id.Setting);
        ListView listView = findViewById(R.id.lsv);
        ArrayList<Chart> chartList = new ArrayList<>();

        Intent intent = this.getIntent();
        chartList.add(new Chart(R.drawable.rest1, "茶湯會", "5.0"));
        chartList.add(new Chart(R.drawable.rest2, "鼎王", "4.9"));
        chartList.add(new Chart(R.drawable.rest3, "瓦城", "4.8"));
        chartList.add(new Chart(R.drawable.rest4, "烏龍麵所", "4.5"));
        chartList.add(new Chart(R.drawable.rest5, "鼎泰豐", "4.0"));


        ChartArrayAdapter adapter = new ChartArrayAdapter(this,
                R.layout.chart_layout, chartList);
        listView.setAdapter(adapter);

        //偵測被按到餐廳
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(ChartActivity.this, MealActivity.class);
                it.putExtra(SHOP_NO, position);
                startActivity(it);
            }
        });


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ChartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ChartActivity.this, ShoppingcartActivity.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ChartActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ChartActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }


}