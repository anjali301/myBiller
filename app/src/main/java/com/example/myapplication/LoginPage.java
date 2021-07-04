package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class LoginPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Button loginButton = findViewById(R.id.reg_btn);
    }
    public void proceedMainPage(View view) {
        Intent i = new Intent(this, homepage.class);
        startActivity(i);
    }
    public void gotoRegister(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
    
}
