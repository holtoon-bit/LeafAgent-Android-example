package com.market.leafandroid.repositories.seller;

import com.market.leafandroid.sellers.Seller;

import java.util.LinkedList;

public class SellerRepositoryImpl implements SellerRepository {
    private final SellerDAO sellerDAOImpl;

    public SellerRepositoryImpl() {
        sellerDAOImpl = new SellerDAOImpl();
    }

    @Override
    public void add(Seller seller) {
        sellerDAOImpl.create(seller);
    }

    @Override
    public Seller get(int id) {
        return sellerDAOImpl.read(id);
    }

    @Override
    public LinkedList<Seller> getAll() {
        return sellerDAOImpl.readAll();
    }

    @Override
    public void update(Seller seller) {
        sellerDAOImpl.update(seller);
    }

    @Override
    public void remove(Seller seller) {
        sellerDAOImpl.delete(seller);
    }
}
