package com.market.leafandroid.activities.seller;

import android.net.Uri;

import com.market.leafandroid.objects.Seller;
import com.market.leafandroid.repositories.seller.SellerRepository;
import com.market.leafandroid.repositories.seller.SellerRepositoryImpl;
import com.market.leafandroid.repositories.seller.database.local.SQLiteDBHelper;

public class SellerPresenter {
    private SellerView view;
    private SellerRepository sellerRepository;
    private Seller seller;

    public SellerPresenter(SellerView view) {
        this.view = view;
    }

    public void updateProfileInfo() {
        new Thread(() -> {
            if (sellerRepository == null) {
                SQLiteDBHelper.createDefault(view.getBaseContext());
                sellerRepository = new SellerRepositoryImpl();
            }
            int id = view.intent().getIntExtra("seller_id", -1);
            setSellerInfo(sellerRepository.get(id));
        }).start();
    }

    private void setSellerInfo(Seller seller) {
        this.seller = seller;
        view.getName().setText(seller.getName());
        view.getAvatar().setImageURI(Uri.parse(seller.getImage()));
    }
}
