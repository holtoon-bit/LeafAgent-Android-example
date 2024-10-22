package com.market.leafandroid.repositories.seller;

import com.market.leafandroid.sellers.Seller;

import java.util.LinkedList;

public interface SellerDAO {
    void create(Seller seller);
    Seller read(int id);
    LinkedList<Seller> readAll();
    void update(Seller seller);
    void delete(Seller seller);
}
