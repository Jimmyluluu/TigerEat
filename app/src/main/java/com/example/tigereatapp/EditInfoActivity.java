package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditInfoActivity extends AppCompatActivity {

    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        btnConfirm = findViewById(R.id.btnConfirm);

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
}