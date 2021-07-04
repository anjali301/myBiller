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
    DatabaseHelper myDb;
    EditText editProductName, editDescription, editPrice, editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product);
        myDb = new DatabaseHelper(this);
        editProductName = (EditText) findViewById(R.id.editTextTextPersonName3);
        editDescription = (EditText) findViewById(R.id.editTextTextPersonName4);
        editPrice = (EditText) findViewById(R.id.editTextTextPersonName5);
        editTextId = (EditText) findViewById(R.id.editTextTextPersonName6);
        btnAddData = (Button) findViewById(R.id.button4);
        btnviewAll = (Button)findViewById(R.id.button7);
        btnviewUpdate = (Button)findViewById(R.id.button8);
        btnDelete= (Button)findViewById(R.id.button9);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText(), toString());
                        if(deletedRows>0)
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(), editProductName.getText().toString(),
                                editDescription.getText().toString(), editPrice.getText().toString() );
                        if(isUpdate)
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                v -> {
                    boolean isInserted = myDb.insertData(editProductName.getText().toString(), editDescription.getText().toString(),
                            editPrice.getText().toString());

                    if (isInserted)
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
        );
    }

    public void viewAll(){
        btnviewAll.setOnClickListener(
                v -> {
                    Cursor res = myDb.getAllData();
                    if(res.getCount() == 0){
                        //show message
                        showMessage("Error", "No Data");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("ID:").append(res.getString(0)).append("\n");
                        buffer.append("Name:").append(res.getString(1)).append("\n");
                        buffer.append("Description:").append(res.getString(2)).append("\n");
                        buffer.append("Price:").append(res.getString(3)).append("\n");
                    }
                    //Show all data
                    showMessage("data", buffer.toString());
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