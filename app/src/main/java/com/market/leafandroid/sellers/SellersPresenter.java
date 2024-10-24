package com.market.leafandroid.sellers;

import com.market.leafandroid.repositories.seller.SellerRepositoryImpl;
import com.market.leafandroid.repositories.seller.database.local.SQLiteDBHelper;

public class SellersPresenter {
    private SellersView view;
    private SellerRepositoryImpl sellerRepository;

    public SellersPresenter(SellersView view) {
        this.view = view;
    }

    public void loadAllSellers() {
        new Thread(() -> {
            if (sellerRepository == null) {
                SQLiteDBHelper.createDefault(view.getBaseContext());
                sellerRepository = new SellerRepositoryImpl();
            }
            view.addSellers(sellerRepository.getAll());
        }).start();
    }

    public void destroy() {
        SQLiteDBHelper.getDefault().close();
    }
}
