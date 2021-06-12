package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run()
            {
                Intent homeIntent;
                homeIntent = new Intent(SplashScreen.this, OptionActivity.class);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(homeIntent);
                finish();
            }
        },2000);
    }
}