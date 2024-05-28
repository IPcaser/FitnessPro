package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper( Context context) {
        super(context,"LoginDb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDb) {
        myDb.execSQL("create table users(Username text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDb, int i, int i1) {
        myDb.execSQL("drop table if exists user");
    }

    public boolean insertData(String username , String password ){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = DB.insert("users",null,contentValues);

        if(result==-1){
            return false;
        }
        else{
            return true;
        }

    }

    public Boolean checkUser(String username){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from users where username = ?" , new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from users where username = ? and password = ?" , new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

}
