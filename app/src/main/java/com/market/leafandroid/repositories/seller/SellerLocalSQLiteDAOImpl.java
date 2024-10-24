package com.market.leafandroid.repositories.seller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.market.leafandroid.repositories.seller.database.local.SQLiteDBHelper;
import com.market.leafandroid.repositories.seller.database.local.SQLiteDBContract.SellerEntry;
import com.market.leafandroid.objects.Seller;

import java.util.LinkedList;

public class SellerLocalSQLiteDAOImpl implements SellerDAO {
    private SQLiteDBHelper dbHelper;
    private SQLiteDatabase db;

    // Must run not into Main Thread
    public SellerLocalSQLiteDAOImpl() {
        dbHelper = SQLiteDBHelper.getDefault();
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void create(Seller seller) {
        ContentValues values = new ContentValues();
        values.put(SellerEntry.COLUMN_NAME, seller.getName());
        values.put(SellerEntry.COLUMN_IMAGE, seller.getImage());

        db.insert(SellerEntry.TABLE_NAME, null, values);
    }

    @Override
    public Seller read(int id) {
        String[] resultColumns = {
                SellerEntry._ID,
                SellerEntry.COLUMN_NAME,
                SellerEntry.COLUMN_IMAGE
        };

        String where = String.format("%s = ?", SellerEntry._ID) ;
        String[] whereValues = {Integer.toString(id)};

        Cursor result = db.query(
                SellerEntry.TABLE_NAME,
                resultColumns,
                where,
                whereValues,
                null,
                null,
                null
        );

        Seller seller = null;
        if (result.moveToNext()) {
            seller = new Seller(
                    result.getInt(result.getColumnIndexOrThrow(SellerEntry._ID)),
                    result.getString(result.getColumnIndexOrThrow(SellerEntry.COLUMN_NAME)),
                    result.getString(result.getColumnIndexOrThrow(SellerEntry.COLUMN_NAME))
            );
        }
        result.close();
        return seller;
    }

    @Override
    public LinkedList<Seller> readAll() {
        String[] resultColumns = {
                SellerEntry._ID,
                SellerEntry.COLUMN_NAME,
                SellerEntry.COLUMN_IMAGE
        };

        Cursor results = db.query(
                SellerEntry.TABLE_NAME,
                resultColumns,
                null,
                null,
                null,
                null,
                null
        );

        LinkedList<Seller> sellers = new LinkedList<>();
        while (results.moveToNext()) {
            sellers.add(new Seller(
                    results.getInt(results.getColumnIndexOrThrow(SellerEntry._ID)),
                    results.getString(results.getColumnIndexOrThrow(SellerEntry.COLUMN_NAME)),
                    results.getString(results.getColumnIndexOrThrow(SellerEntry.COLUMN_NAME))
            ));
        }
        results.close();

        return sellers;
    }

    @Override
    public void update(Seller seller) {
        ContentValues values = new ContentValues();
        values.put(SellerEntry._ID, seller.getId());
        values.put(SellerEntry.COLUMN_NAME, seller.getName());
        values.put(SellerEntry.COLUMN_IMAGE, seller.getImage());

        String where = SellerEntry._ID + " == ?";
        String[] whereValues = {Integer.toString(seller.getId())};

        db.update(
                SellerEntry.TABLE_NAME,
                values,
                where,
                whereValues
        );
    }

    @Override
    public void delete(Seller seller) {
        String where = String.format("%s == ?", SellerEntry._ID);
        String[] whereValues = {Integer.toString(seller.getId())};
        db.delete(SellerEntry.TABLE_NAME, where, whereValues);
    }
}
