package com.example.sayalvaidya.trackurride.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sayalvaidya.trackurride.domain.Mileages;
import com.example.sayalvaidya.trackurride.domain.Services;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sayalvaidya on 5/1/17.
 */

public class DatabaseConnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "vehicle.db";

    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_MILEAGE = "vehicle_mileage";

    public final String V_ID = "_id";
    public final String Initial_km = "I_km";
    public final String Final_km = "F_km";
    public final String refulled_quantity = "R_quantity";
    public final String Mileage ="Mileage";

    private static final String TABLE_SERVICE = "vehicle_service";

    public final String S_ID = "_id";
    public final String Serviced_date ="Serviced_date";
//    public final String Initial_km_S = "I_km";
    public final String Final_km_S = "Final_km_s";
//    public final String Servicing_date = "S_date";
    public final String Notes = "Notes";

    Context context;

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context= context;
 //      SQLiteDatabase db= this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MILEAGE
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "I_km INTEGER, " +
                "F_km INTEGER," +
                "R_quantity INTEGER, " +
                " Mileage DOUBLE)");
        ContentValues cv = new ContentValues();
        cv.put(refulled_quantity, "10");
        cv.put(Initial_km, "4000");
        cv.put(Final_km, "4500");
        cv.put(Mileage,"50");
        db.insert(TABLE_MILEAGE, V_ID, cv);



        db.execSQL("CREATE TABLE " + TABLE_SERVICE
                + "(_id INTEGER PRIMARY KEY," +
                "Serviced_date TEXT," +
                "Final_km_s TEXT," +
                "Notes TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_MILEAGE);
        db.execSQL("DROP TABLE IF EXIST" + TABLE_SERVICE);
        onCreate(db);
    }
    public void insert_Mileage(Mileages mileage){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues cv = new ContentValues();

        cv.put(Initial_km,mileage.getInitial_km());
        cv.put(Final_km,mileage.getFinal_km());
        cv.put(refulled_quantity, mileage.getRefulled_quantity());
        cv.put(Mileage,mileage.getMileage());
        db.insert(TABLE_MILEAGE, V_ID, cv);
        db.setTransactionSuccessful();
        System.out.println("Successfully inserted");
        db.endTransaction();
        db.close();
        this.close();
    }



    public void insert_Service(Services service){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues cv = new ContentValues();

        cv.put(Serviced_date, service.getServiced_date());
//        cv.put(Initial_km_S,service.getInitial_km_S());
        cv.put(Final_km_S,service.getFinal_km_S());
        cv.put(Notes,service.getNotes());

        db.insert(TABLE_SERVICE, S_ID, cv);
        db.setTransactionSuccessful();
        System.out.println("Inserted in service");
        db.endTransaction();
        db.close();
        this.close();
    }


    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_MILEAGE,null);
        System.out.println("Successfully inserted");

        return res;


    }

    public Cursor getData_s(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor rest=db.rawQuery("select * from "+TABLE_SERVICE,null);
        System.out.println("Successfully inserted");

        return rest;


    }



}





