package com.example.tigereatapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
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

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InfoActivity extends AppCompatActivity {

    TextView tvLogout;
    TextView tvInfoEdit;
    ImageView ivInfoPhoto;
    String picName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvLogout = findViewById(R.id.tvLogout);
        tvInfoEdit = findViewById(R.id.tvInfoEdit);
        ivInfoPhoto = findViewById(R.id.ivInfoPhoto);

        Log.i("before", "");
        getPicName();
        Log.i("after", "");

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

    private void getPicName() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference infoRef = mDatabase.child("email").child("infopic").child(User.name);
        Log.i("info", infoRef.toString());

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                String pic = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                Log.i("picname", pic);
                setPic(pic);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        infoRef.addValueEventListener(postListener);
        Log.i("finish", "");
    }

    private void setPic(String p) {

        Log.i("get", p);
        //取得firebase storage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference imageRef = storage.getReference()
                .child("images").child(User.name).child(p);

        Log.i("", imageRef.toString());

        final long ONE_MEGABYTE = 1024 * 1024;
        imageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                ivInfoPhoto.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                exception.printStackTrace();
            }
        });
    }
}