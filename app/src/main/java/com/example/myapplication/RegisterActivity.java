package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    protected EditText edUsername, businessName, edPassword, edConfirmPassword;
    protected Button btnCreateUser;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edUsername = findViewById(R.id.editTextTextPersonName);
        businessName = findViewById(R.id.editTextTextPersonName2);
        edPassword = findViewById(R.id.editTextTextPassword);
        edConfirmPassword = findViewById(R.id.editTextTextPassword3);
        btnCreateUser = findViewById(R.id.reg_btn);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strPassword = edPassword.getText().toString();
                String strConfirmPassword = edConfirmPassword.getText().toString();
                String strUsername = edUsername.getText().toString();

                if (strPassword != null && strConfirmPassword != null && strPassword.equalsIgnoreCase(strConfirmPassword)){
                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password", strPassword);
                    editor.putString("Username", strUsername);
                    editor.commit();

                    RegisterActivity.this.finish();
                }
            }
        });

    }
    public void proceedOTP(View view) {
        startActivity(new Intent(this, LoginPage.class));
    }
    public void gotoLogin(View view) {
        startActivity(new Intent(this, LoginPage.class));
    }
}
