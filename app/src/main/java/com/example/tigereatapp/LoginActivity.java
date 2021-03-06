package com.example.tigereatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements OnCompleteListener<AuthResult> {

    public static final String USER_STATE = "userState";
    public TextView tv2Regist;
    private Button btnLogin;
    private EditText etCostomerAccount;
    private EditText etCostomerPassword;
    private String email;
    private String password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv2Regist = findViewById(R.id.tvToRegist);
        btnLogin = findViewById(R.id.btnCostomerRegist);
        etCostomerAccount = findViewById(R.id.etCostomerRegistAccount);
        etCostomerPassword = findViewById(R.id.etCostomerRegistPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        Intent getIntent = getIntent();
        //getIntent.getSerializableExtra();
    }

    public void Regist(View view) {
        Intent intent = new Intent(this, CostomerRegisterActivity.class);
        startActivity(intent);
    }

    public void onLogin(View view) {
        /**
         * account: test@mail.com
         * password: 1111111
         */

        email = etCostomerAccount.getText().toString();
        password = etCostomerPassword.getText().toString();

        SharedPreferences sharedPreferences =
                getSharedPreferences("login", Context.MODE_PRIVATE);
        if (email != null && password != null) {
            sharedPreferences.edit()
                    .putBoolean("loggedIn", true)
                    .putString("account", etCostomerAccount.getText().toString())
                    .putString("password", etCostomerPassword.getText().toString())
                    .apply();
        } else {
            email = sharedPreferences.getString("account", "account");
            password = sharedPreferences.getString("password", "password");
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, this);

        /*//??????
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
            Toast.makeText(this, "?????????????????????", Toast.LENGTH_LONG).show();
            Log.i("accountAndPassword", "wrong");
            Log.i("account", etCostomerAccount.getText().toString());
            Log.i("password", etCostomerPassword.getText().toString());
        }*/

        /*Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(USER_STATE, UserState.COSTOMER_USER);
        startActivity(intent);*/
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Toast.makeText(this, "????????????", Toast.LENGTH_LONG)
                    .show();

            User.email = email;
            User.password = password;
            StringBuffer stringBuffer = new StringBuffer(email);
            stringBuffer.replace(email.indexOf("@"),
                    email.length(), "");
            User.account = stringBuffer.toString();
            User.userState = UserState.COSTOMER_USER;

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "????????????", Toast.LENGTH_LONG)
                    .show();
        }
    }
}