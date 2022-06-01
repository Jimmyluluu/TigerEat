package com.example.tigereatapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InfoActivity extends AppCompatActivity {

    TextView tvLogout;
    TextView tvInfoEdit;
    ImageView ivInfoPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvLogout = findViewById(R.id.tvLogout);
        tvInfoEdit = findViewById(R.id.tvInfoEdit);
        ivInfoPhoto = findViewById(R.id.ivInfoPhoto);

        tvLogout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // firebase logout

                // logout
                User.userState = UserState.ILLEGAL_USER;

                SharedPreferences sharedPreferences =
                    getSharedPreferences("login", Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();

                Intent intent = new Intent(
                        InfoActivity.this, WelcomeActivity.class).
                        setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return false;
            }
        });

        tvInfoEdit.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(InfoActivity.this, EditInfoActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
}