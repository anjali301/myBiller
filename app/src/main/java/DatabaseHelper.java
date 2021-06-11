package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "product.db";
    public static final String TABLE_NAME = "product_table";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "Name";
    public static final String Col_3 = "Description";
    public static final String Col_4 = "Price";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table product_table(ID INTEGER PRIMARY KEY AUTOINCREMENT,  Name TEXT, Description TEXT, Price INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
    }
    public boolean insertData(String name, String description, String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, name);
        contentValues.put(Col_3, description);
        contentValues.put(Col_4, price);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}