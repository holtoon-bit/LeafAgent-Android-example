package com.market.leafandroid.sellers;

import com.market.leafandroid.repositories.seller.SellerRepositoryImpl;

public class SellersPresenter {
    private SellersView view;
    private SellerRepositoryImpl sellerRepository= new SellerRepositoryImpl();

    public SellersPresenter(SellersView view) {
        this.view = view;
    }

    public void loadAllSellers() {
        view.addSellers(sellerRepository.getAll());
    }
}
