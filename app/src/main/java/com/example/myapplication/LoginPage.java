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
    protected EditText edUsername, edPassword; //
    protected Button btnLogin;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref"; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.editTextTextPersonName);  //
        edPassword = findViewById(R.id.editTextTextPassword);//
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        btnLogin = findViewById(R.id.reg_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences credential = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String strUsername = credential.getString("Username", null);
                String strPassword = credential.getString("Password", null);

                String username_from_ed = edUsername.getText().toString();
                String password_from_ed = edPassword.getText().toString();

                if (strUsername != null && username_from_ed != null &&  strUsername.equalsIgnoreCase(username_from_ed)){
                    if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed)){
                        Toast.makeText(LoginPage.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
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
