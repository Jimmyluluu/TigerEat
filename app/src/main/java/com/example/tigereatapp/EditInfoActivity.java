package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditInfoActivity extends AppCompatActivity {

    private Button btnConfirm;
    private ImageView ivPhoto;
    private ImageView ivCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        ivPhoto = findViewById(R.id.ivSetPhoto);
        btnConfirm = findViewById(R.id.btnConfirm);
        ivCamera = findViewById(R.id.ivCamera);

        ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = findViewById(R.id.etEditName);
                TextView tvEmail = findViewById(R.id.tvShowEmail);
                EditText etPhone = findViewById(R.id.etEditPhone);
                EditText etAddress = findViewById(R.id.etEditAddress);
                finish();
            }
        });
    }

    public  void openCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, 2);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
            e.printStackTrace();
        }
    }
}