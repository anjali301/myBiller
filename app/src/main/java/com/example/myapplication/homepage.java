package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class homepage extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
//    com.example.myapplication.DatabaseHelper myDb;
    EditText editProductName, editDescription, editPrice;
    Button btnAddData;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about, R.id.nav_contact, R.id.nav_client, R.id.nav_product)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//        myDb = new com.example.myapplication.DatabaseHelper(this);

        editProductName = (EditText) findViewById(R.id.editTextTextPersonName3);
        editDescription = (EditText) findViewById(R.id.editTextTextPersonName4);
        editPrice = (EditText) findViewById(R.id.editTextTextPersonName5);
        btnAddData = (Button) findViewById(R.id.button4);
        btnviewAll = (Button) findViewById(R.id.button7);
//        AddData();
//        viewAll();
    }

//    public void AddData() {
//        btnAddData.setOnClickListener(
//                v -> {
//                    boolean isInserted = myDb.insertData(editProductName.getText().toString(), editDescription.getText().toString(),
//                            editPrice.getText().toString());
//
//                    if (isInserted = true)
//                        Toast.makeText(homepage.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                    else
//                        Toast.makeText(homepage.this, "Data not Inserted", Toast.LENGTH_LONG).show();
//                }
//        );
//    }

//    public void viewAll() {
//        btnviewAll.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                        Cursor res = myDb.getAllData();
////                        if (res.getCount() == 0) {
//                            //show message
//                            showMessage("Error", "No Data");
//                            return;
//                        }
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext()) {
//                            buffer.append("ID:" + res.getString(0) + "\n");
//                            buffer.append("Name:" + res.getString(1) + "\n");
//                            buffer.append("Description:" + res.getString(2) + "\n");
//                            buffer.append("Price:" + res.getString(3) + "\n");
//                        }
//                        //Show all data
//                        showMessage("data", buffer.toString());
//                    }
//
//                }
//        );
//    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.homepage, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        return true;
//    }
}