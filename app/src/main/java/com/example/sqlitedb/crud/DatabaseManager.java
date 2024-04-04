package com.example.sqlitedb.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_contacts.db";
    private static final String TABLE_NAME = "contacts";

    public DatabaseManager(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(25) NOT NULL,Mobile INTEGER(10) NOT NULL,Email TEXT,Address TEXT,Relation VARCHAR(25))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int insertData(String name,String mobile,String email,String address,String relation){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where Mobile = "+mobile,null);
        if(cursor.getCount()>0)return 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Mobile",mobile);
        contentValues.put("Email",email);
        contentValues.put("Address",address);
        contentValues.put("Relation",relation);
        long result = db.insert(TABLE_NAME,null,contentValues);
        return result>0?1:-1;
    }

    public int updateData(String name,String mobile,String email,String address,String relation){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where Mobile = "+mobile,null);
        if(cursor.getCount()==0)return 0;

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Mobile",mobile);
        contentValues.put("Email",email);
        contentValues.put("Address",address);
        contentValues.put("Relation",relation);
        long result = db.update(TABLE_NAME,contentValues,"Mobile=?",new String[]{mobile});
        return result>0?1:-1;
    }

    public int deleteData(String name,String mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where Mobile = "+mobile+" AND Name = "+name,null);
        //if(cursor.getCount()==0)return 0;
        long result = db.delete(TABLE_NAME,"Mobile=? AND Name=?",new String[]{mobile,name});
        return result>0?1:-1;
    }

    public Cursor viewAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }
}
