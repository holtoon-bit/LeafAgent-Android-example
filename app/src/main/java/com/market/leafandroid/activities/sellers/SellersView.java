package com.market.leafandroid.activities.sellers;

import android.content.Context;

import com.market.leafandroid.objects.Seller;

import java.util.LinkedList;

public interface SellersView {
    void addSellers(LinkedList<Seller> sellers);
    void addSeller(Seller seller);
    Context getBaseContext();
}
