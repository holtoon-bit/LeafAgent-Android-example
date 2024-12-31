package com.market.leafandroid.activities.sellers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.market.leafandroid.R;
import com.market.leafandroid.objects.Seller;

import java.util.LinkedList;

import leafagent.annotations.Branch;
import leafagent.annotations.Leaf;
import leafagent.utils.JsonWriter;

@Branch
public class SellersActivity extends AppCompatActivity implements SellersView {
    private SellerListAdapter adapter;
    private SellersPresenter presenter;

    public SellersActivity() {
    }

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
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();

//        LeafGetter leafPrinter = new LeafGetter();
//        System.out.println("=> " + ActivityRoot.getTrunks());
//        ActivityRoot.getTrunks().forEach((list1) -> {
//            System.out.println("==> " + leafPrinter.getChildren(list1));
//            leafPrinter.getChildren(list1).forEach((list2) -> {
//                System.out.println("===> " + leafPrinter.getChildren(list2));
//            });
//        });
    }

    @Leaf
    @Override
    public void addSellers(LinkedList<Seller> sellers) {
        runOnUiThread(() -> adapter.addAllSellers(sellers));
    }

    @Override
    public void addSeller(Seller seller) {
        runOnUiThread(() -> adapter.addSeller(seller));
    }
}