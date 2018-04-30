package com.example.william.studentbazaar.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.UserTable;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.ItemTable;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.InClubTable;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.EventTable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "studentBazaar.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ClubTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                ClubTable.Cols.UUID + ", " +
                ClubTable.Cols.NAME + ", " +
                ClubTable.Cols.DESCRIPTION +
                ")"
        );

        db.execSQL("create table " + UserTable.NAME + "(" +
                UserTable.Cols.STUDENTID + " INTEGER PRIMARY KEY, " +
                UserTable.Cols.UUID + " TEXT NOT NULL, " +
                UserTable.Cols.FIRSTNAME + " TEXT NOT NULL, " +
                UserTable.Cols.LASTNAME + " TEXT NOT NULL, " +
                UserTable.Cols.PHONENUMBER + " TEXT NOT NULL, " +
                UserTable.Cols.EMAIL + " TEXT NOT NULL UNIQUE, " +
                UserTable.Cols.PASSWORD + " TEXT NOT NULL" +
                ")"
        );

        db.execSQL("create table " + ItemTable.NAME + "(" +
                ItemTable.Cols.UUID + " TEXT NOT NULL, " +
                ItemTable.Cols.OWNERID + " INTEGER NOT NULL, " +
                ItemTable.Cols.NAME + " TEXT NOT NULL, " +
                ItemTable.Cols.DESCRIPTION + " TEXT NOT NULL, " +
                ItemTable.Cols.ONSALE +
                ", PRIMARY KEY (" + ItemTable.Cols.OWNERID + ", " + ItemTable.Cols.NAME + ")" +
                ")"
        );

        db.execSQL("create table " + InClubTable.NAME + "(" +
                InClubTable.Cols.UUID + ", " +
                InClubTable.Cols.CLUBID + " TEXT NOT NULL, " +
                InClubTable.Cols.STUDENTID + " INTEGER NOT NULL" +
                ", PRIMARY KEY (" + InClubTable.Cols.CLUBID + ", " + InClubTable.Cols.STUDENTID + ")" +
                ")"
        );

        db.execSQL("create table " + EventTable.NAME + "(" +
                EventTable.Cols.UUID + " TEXT NOT NULL, " +
                EventTable.Cols.OWNERID + " INTEGER NOT NULL, " +
                EventTable.Cols.NAME + " TEXT NOT NULL, " +
                EventTable.Cols.DESCRIPTION + " TEXT NOT NULL, " +
                EventTable.Cols.ONDISPLAY +
                ", PRIMARY KEY (" + EventTable.Cols.OWNERID + ", " + EventTable.Cols.NAME + ")" +
                ")"
        );
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}