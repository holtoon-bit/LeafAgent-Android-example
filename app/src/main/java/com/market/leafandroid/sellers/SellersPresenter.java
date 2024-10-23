package com.market.leafandroid.sellers;

import com.market.leafandroid.repositories.seller.SellerRepositoryImpl;
import com.market.leafandroid.repositories.seller.database.local.SQLiteDBHelper;

public class SellersPresenter {
    private SellersView view;
    private SellerRepositoryImpl sellerRepository;

    public SellersPresenter(SellersView view) {
        this.view = view;

        SQLiteDBHelper.createDefault(view.getBaseContext());
        sellerRepository = new SellerRepositoryImpl(); // вызвать, вместе с loadAllSellers(), позже прошлого метода
    }

    public void loadAllSellers() {
        view.addSellers(sellerRepository.getAll());
    }

    public void destroy() {
        SQLiteDBHelper.getDefault().close();
    }
}
