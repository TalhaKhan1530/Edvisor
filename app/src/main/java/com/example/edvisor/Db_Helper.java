package com.example.edvisor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Db_Helper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Clock.db";
    public Db_Helper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE Customer (Id int PRIMARY KEY, " +
                "name TEXT," +
                "payment_method TEXT)";
        String sql2 = "CREATE TABLE Edvisor (Id int PRIMARY KEY, " +
                "name TEXT," +
                "expert_in TEXT," +
                "avg_rating float)";
        db.execSQL(sql);
        db.execSQL(sql2);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Edvisor");
        db.execSQL("DROP TABLE IF EXISTS Customer");
        onCreate(db);
    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db,oldVersion,newVersion);
    }

    public boolean Add_data_Customer(Customer data)
    {
        deleteall_Customer();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
            contentValues.put("Id",data.id);
            contentValues.put("name",data.name);
            contentValues.put("payment_method",data.payment_method);


        long result=db.insert("Customer",null,contentValues);
        if (result==-1)
        {
            return false;
        }
        return true;

    }

    public boolean Add_data_Edvisor(Edvisor data)
    {
        deleteall_Edvisor();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Id",data.id);
        contentValues.put("Name",data.Name);
        contentValues.put("Avg_rating",data.average_rating);
        contentValues.put("Expert_in",data.expert_in);

        long result=db.insert("Edvisor",null,contentValues);
        if (result==-1)
        {
            return false;
        }
        return true;

    }

    public Cursor load_data_customer()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM Customer",null);
        return data;

    }

    public Cursor load_data_Edvisor()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM Edvisor",null);
        return data;

    }

    public void deleteall_Customer()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        // db.execSQL("delete  from Clocks",null);
        db.delete("Customer",null,null);
    }

    public void deleteall_Edvisor()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        // db.execSQL("delete  from Clocks",null);
        db.delete("Edvisor",null,null);
    }

}
