package com.market.leafandroid.repositories.seller;

import com.market.leafandroid.objects.Seller;

import java.util.LinkedList;

public interface SellerRepository {
    void add(Seller seller);
    Seller get(int id);
    LinkedList<Seller> getAll();
    void update(Seller seller);
    void remove(Seller seller);
}
