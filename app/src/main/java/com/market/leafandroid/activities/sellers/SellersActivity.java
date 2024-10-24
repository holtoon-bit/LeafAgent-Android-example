package com.market.leafandroid.activities.sellers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.market.leafandroid.R;
import com.market.leafandroid.objects.Seller;

import java.util.LinkedList;

public class SellersActivity extends AppCompatActivity implements SellersView {

    private SellerListAdapter adapter;
    private SellersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers);
        presenter = new SellersPresenter(this);

        RecyclerView sellersRecycler = findViewById(R.id.sellers_view);
        sellersRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new SellerListAdapter();
        sellersRecycler.setAdapter(adapter);

        presenter.loadAllSellers();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @Override
    public void addSellers(LinkedList<Seller> sellers) {
        runOnUiThread(() -> adapter.addAllSellers(sellers));
    }

    @Override
    public void addSeller(Seller seller) {
        runOnUiThread(() -> adapter.addSeller(seller));
    }

}