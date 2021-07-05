package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class LoginPage extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.reg_btn);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(LoginPage.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                    proceedMainPage();
                }
            }
        });

    }
    public void proceedMainPage() {
        Intent i = new Intent(this, homepage.class);
        Toast.makeText(LoginPage.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
    public void gotoRegister(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }


}
