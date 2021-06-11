package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editProductName, editDescription, editPrice;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editProductName = (EditText) findViewById(R.id.editTextTextPersonName3);
        editDescription = (EditText) findViewById(R.id.editTextTextPersonName4);
        editPrice = (EditText) findViewById(R.id.editTextTextPersonName5);
        btnAddData = (Button) findViewById(R.id.button4);
        AddData();
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isinserted = myDb.insertData(editProductName.getText().toString(), editDescription.getText().toString(),
                                editPrice.getText().toString());

                        if (isinserted = true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
