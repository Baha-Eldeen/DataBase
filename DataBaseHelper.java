package com.example.bahaeldeen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME=" User.id ";
    public static final String TABLE_Name=" User_Table ";
    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="PASSWORD";
    public static final String COL4="EMAIL";
    public static final String COL5="PHONE";

    public DataBaseHelper(Context context) { super(context, DB_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table "+TABLE_Name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , PASSWORD INTEGER ,EMAIL TEXT , PHONE INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXIST "+TABLE_Name);
    }

    public boolean RegData(String name ,String pass ,String email ,String phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,pass);
        contentValues.put(COL4,email);
        contentValues.put(COL5,phone);

        long result=db.insert(TABLE_Name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }


    public boolean ExistUser(String name ,String pass) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = " select * form " + TABLE_Name + " where " + COL2 + " = " + "'" + name + "'" + " and " + COL3 + " = " + "'" + pass + "'";
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }

        cursor.close();
        db.close();
        return false;

    }
}
