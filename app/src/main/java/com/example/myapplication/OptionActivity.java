package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class OptionActivity extends AppCompatActivity {

    protected Button buttonLogin, buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_res);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        buttonLogin = findViewById(R.id.button_login);
        buttonRegister = findViewById(R.id.button_register);
    }
    public void proceedLogin(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
    public void proceedRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
