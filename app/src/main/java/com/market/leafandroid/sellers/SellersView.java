package com.market.leafandroid.sellers;

import android.content.Context;

import java.util.LinkedList;

public interface SellersView {
    void addSellers(LinkedList<Seller> sellers);
    void addSeller(Seller seller);
    Context getBaseContext();
}
