package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CostomerRegisterActivity extends AppCompatActivity {

    private Button btnCostomerRegist;
    private EditText etCostomerRegistAccount;
    private EditText etCostomerRegistPassword;
    private EditText etCostomerRegistName;
    private EditText etCostomerRegistPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costomer_register);

        Intent intent = getIntent();

        btnCostomerRegist = findViewById(R.id.btnCostomerRegist);
        btnCostomerRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();

            }
        });
    }

    public void init() {
        etCostomerRegistAccount = findViewById(R.id.etCostomerRegistAccount);
        etCostomerRegistPassword = findViewById(R.id.etCostomerRegistPassword);
        etCostomerRegistName = findViewById(R.id.etCostomerRegistName);
        etCostomerRegistPhone = findViewById(R.id.etCostomerRegistPhone);
    }
}