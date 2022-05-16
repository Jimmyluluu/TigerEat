package com.example.tigereatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String USER_STATE = "userState";
    public TextView tv2Regist;
    private Button btnLogin;
    private EditText etCostomerAccount;
    private EditText etCostomerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv2Regist = findViewById(R.id.tvToRegist);
        btnLogin = findViewById(R.id.btnCostomerLogin);
        etCostomerAccount = findViewById(R.id.etCostomerAccount);
        etCostomerPassword = findViewById(R.id.etCostomerPassword);
    }

    public void Regist(View view) {
    }

    public void Login(View view) {
        /**
         * account: admin
         * password: 12345
         */

        //驗證
        CheckUser checkUser = new CheckUser(
                etCostomerAccount.getText().toString(), etCostomerPassword.getText().toString());

        if (checkUser.check()) {
            Log.i("accountAndPassword", "correct");
            Log.i("account", etCostomerAccount.getText().toString());
            Log.i("password", etCostomerPassword.getText().toString());
            SharedPreferences sharedPreferences =
                    getSharedPreferences("login", Context.MODE_PRIVATE);
            sharedPreferences.edit()
                    .putBoolean("loggedIn", true)
                    .putString("account", etCostomerAccount.getText().toString())
                    .putString("password", etCostomerPassword.getText().toString())
                    .apply();

            finish();
        } else {
            Toast.makeText(this, "帳號或密碼錯誤", Toast.LENGTH_LONG).show();
            Log.i("accountAndPassword", "wrong");
            Log.i("account", etCostomerAccount.getText().toString());
            Log.i("password", etCostomerPassword.getText().toString());
        }

        /*Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(USER_STATE, UserState.COSTOMER_USER);
        startActivity(intent);*/
    }
}