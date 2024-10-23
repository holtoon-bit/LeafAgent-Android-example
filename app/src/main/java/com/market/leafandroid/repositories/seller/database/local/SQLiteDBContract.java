package com.market.leafandroid.repositories.seller.database.local;

import android.provider.BaseColumns;

public class SQLiteDBContract {
    private SQLiteDBContract() {}

    public static class SellerEntry implements BaseColumns {
        public static final String TABLE_NAME = "seller";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMAGE = "image";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " +
            SellerEntry.TABLE_NAME + " (" +
            SellerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SellerEntry.COLUMN_NAME + " TEXT, " +
            SellerEntry.COLUMN_IMAGE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SellerEntry.TABLE_NAME;
}
