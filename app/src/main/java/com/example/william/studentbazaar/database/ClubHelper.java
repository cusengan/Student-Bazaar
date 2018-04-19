package com.example.william.studentbazaar.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable;

public class ClubHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "studentBazaar.db";

    public ClubHelper(Context context) {
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}