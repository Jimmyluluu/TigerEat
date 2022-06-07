package com.example.tigereatapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class InfoActivity extends AppCompatActivity {

    TextView tvLogout;
    TextView tvInfoEdit;
    ImageView ivInfoPhoto;
    String picName;
    private TextView tvName;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvAddress;
    public boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Log.i("state", "oncreate");

        tvLogout = findViewById(R.id.tvLogout);
        tvInfoEdit = findViewById(R.id.tvInfoEdit);
        ivInfoPhoto = findViewById(R.id.ivInfoPhoto);
        tvName = findViewById(R.id.tvInfoName);
        tvEmail = findViewById(R.id.tvInfoAccount);
        tvAddress = findViewById(R.id.tvInfoAddress);
        tvPhone = findViewById(R.id.tvInfoPhone);

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
                edit = true;
                Intent intent = new Intent(InfoActivity.this, EditInfoActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("state", "onstart");
        getInfos();
        Log.i("before", "");
        getPicName();
        Log.i("after", "");
    }

    private void getInfos() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference infoRef = mDatabase.child("costomers").child(User.account);
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                String email = dataSnapshot.child("email").getValue(String.class);
                String name = dataSnapshot.child("name").getValue(String.class);
                String phone = dataSnapshot.child("phone").getValue(String.class);
                String address = dataSnapshot.child("address").getValue(String.class);
                if (email != null) {
                    Log.i("email", email);
                    tvEmail.setText(tvEmail.getText() + " " + email);
                }
                if (name != null) {
                    Log.i("name", name);
                    tvName.setText(tvName.getText() +  " " + name);
                }
                if (phone != null) {
                    Log.i("phone", phone);
                    tvPhone.setText(tvPhone.getText() +  " " + phone);
                }
                if (address != null) {
                    Log.i("address", address);
                    tvAddress.setText(tvAddress.getText() +  " " + address);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        infoRef.addValueEventListener(postListener);
    }

    private void getPicName() {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference infoRef = mDatabase.child("infopic").child(User.account);
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
                .child("images").child(User.account).child(p);

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