package com.example.tigereatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CostomerRegisterActivity extends AppCompatActivity implements OnCompleteListener {

    private Button btnCostomerRegist;
    private EditText etCostomerRegistAccount;
    private EditText etCostomerRegistPassword;
    private EditText etCostomerRegistName;
    private EditText etCostomerRegistPhone;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costomer_register);

        Intent intent = getIntent();
        init();
    }

    public void init() {

        btnCostomerRegist = findViewById(R.id.btnCostomerRegist);

        etCostomerRegistAccount = findViewById(R.id.etCostomerRegistAccount);
        etCostomerRegistPassword = findViewById(R.id.etCostomerRegistPassword);
        etCostomerRegistName = findViewById(R.id.etCostomerRegistName);
        etCostomerRegistPhone = findViewById(R.id.etCostomerRegistPhone);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onRegister(View view) {

        String email = etCostomerRegistAccount.getText().toString();
        String password = etCostomerRegistPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, this);
    }

    @Override
    public void onComplete(@NonNull Task task) {

        if (task.isSuccessful()) {
            Toast.makeText(this, "註冊成功", Toast.LENGTH_LONG)
                    .show();
            addUser();
            finish();
        } else {
            Toast.makeText(this, "註冊失敗", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void addUser() {

        String email = etCostomerRegistAccount.getText().toString();
        String name = etCostomerRegistName.getText().toString();
        String phone = etCostomerRegistPhone.getText().toString();
        StringBuffer stringBuffer = new StringBuffer(email);
        stringBuffer.replace(email.indexOf("@"),
                email.length(), "");
        User.account = stringBuffer.toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference userRef = firebaseDatabase.getReference("costomers");
        DatabaseReference infoRef = userRef.child(User.account);

        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("name", name);
        user.put("phone", phone);
        user.put("address", null);
        infoRef.updateChildren(user);
    }
}