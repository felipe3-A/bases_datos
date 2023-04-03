package com.andres.andresm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQliteOpenHelper extends SQLiteOpenHelper {
    public AdminSQliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table articulos (codigo int primary key,description tesx,precio real)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int i1){}

}

