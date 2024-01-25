package com.example.myapplication.data_base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DataBase";
    private static final int DATABASE_VERSION = 1;
    public static final String NAME_COLUME = "name";
    public static final String AGE_COLUME = "age";

    public DatabaseHelper(Context context, String name,
                          CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS mytable ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUME + " TEXT, "
                + AGE_COLUME + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
