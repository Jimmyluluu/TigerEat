//首頁
package com.example.tigereatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ActionMenuView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tigereatapp.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*BottomNavigationView bottomNavigationView
                = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        switch (item.getItemId()) {

            case R.id.home:

                break;
            case R.id.search:
                //Intent intent2 = new Intent(this, MainActivity.class);
                //startActivity(intent2);
                break;
            case R.id.shopping:
                //Intent intent3 = new Intent(this, PaymentActivity.class);
                //startActivity(intent3);
                break;
            case R.id.personal:
                //Intent intent4 = new Intent(this, InfoActivity.class);
                //startActivity(intent4);
                break;

        }*/
    }
}