package com.market.leafandroid.sellers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.market.leafandroid.R;
import java.util.LinkedList;

public class SellersActivity extends AppCompatActivity implements SellersView {

    SellerListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers);

        RecyclerView sellersRecycler = this.findViewById(R.id.sellers_view);
        sellersRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new SellerListAdapter();
        sellersRecycler.setAdapter(adapter);
    }

    @Override
    public void addSellers(LinkedList<Seller> sellers) {
        adapter.addAllSellers(sellers);
    }

    @Override
    public void addSeller(Seller seller) {
        adapter.addSeller(seller);
    }
}