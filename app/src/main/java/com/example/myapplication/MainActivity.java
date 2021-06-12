package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    com.example.myapplication.DatabaseHelper myDb;
    EditText editProductName, editDescription, editPrice;
    Button btnAddData;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new com.example.myapplication.DatabaseHelper(this);

        editProductName = (EditText) findViewById(R.id.editTextTextPersonName3);
        editDescription = (EditText) findViewById(R.id.editTextTextPersonName4);
        editPrice = (EditText) findViewById(R.id.editTextTextPersonName5);
        btnAddData = (Button) findViewById(R.id.button4);
        btnviewAll = (Button)findViewById(R.id.button7);
        AddData();
        viewAll();
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                v -> {
                    boolean isInserted = myDb.insertData(editProductName.getText().toString(), editDescription.getText().toString(),
                            editPrice.getText().toString());

                    if (isInserted = true)
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
        );
    }

    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            //show message
                            showMessage("Error", "No Data");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID:"+ res.getString(0)+"\n");
                            buffer.append("Name:"+ res.getString(1)+"\n");
                            buffer.append("Description:"+ res.getString(2)+"\n");
                            buffer.append("Price:"+ res.getString(3)+"\n");
                        }
                        //Show all data
                        showMessage("data", buffer.toString());
                    }

                }
        );
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        return true;
    }
}

