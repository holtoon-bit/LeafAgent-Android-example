package com.market.leafandroid.repositories.seller.database.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    public static SQLiteDBHelper defaultHelper;

    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteDBContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLiteDBContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public static void createDefault(Context context) {
        if (defaultHelper == null) {
            defaultHelper = new SQLiteDBHelper(context);
        }
    }

    public static SQLiteDBHelper getDefault() {
        return defaultHelper;
    }
}
