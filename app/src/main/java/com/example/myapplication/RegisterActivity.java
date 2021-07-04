package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    protected EditText username, businessName, password, confirmPass;
    protected Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        username = findViewById(R.id.editTextTextPersonName);
        businessName = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.editTextTextPassword);
        confirmPass = findViewById(R.id.editTextTextPassword3);
        registerButton = findViewById(R.id.reg_btn);
    }
    public void proceedOTP(View view) {
        startActivity(new Intent(this, LoginPage.class));
    }
    public void gotoLogin(View view) {
        startActivity(new Intent(this, LoginPage.class));
    }
}
