package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText username, businessName, password, confirmPassword;
    Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        businessName = findViewById(R.id.editTextTextPersonName);
        username = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.editTextTextPassword);
        confirmPassword = findViewById(R.id.editTextTextPassword3);
        btnCreateUser = findViewById(R.id.btnClient);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(businessName.getText().toString().isEmpty() ||
                    username.getText().toString().isEmpty() ||
                    password.getText().toString().isEmpty() ||
                    confirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                }
                else if(!password.getText().toString().equals(confirmPassword.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
                else{
                    proceedLoginPage();
                }
            }
        });

    }
    public void proceedLoginPage() {
        Intent i = new Intent(this, LoginPage.class);
        Toast.makeText(RegisterActivity.this, "Registered successfully, now proceed to login", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
    public void gotoLogin(View view) {
        startActivity(new Intent(this, LoginPage.class));
    }
}
