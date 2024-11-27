package com.market.leafandroid.activities.seller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.market.leafandroid.R;

public class SellerActivity extends AppCompatActivity implements SellerView {

    private SellerPresenter presenter;

    public void greeting() {
        System.out.println("Hello");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        greeting();
        presenter = new SellerPresenter(this);
        runOnUiThread(() -> presenter.updateProfileInfo());
    }

    @Override
    public Intent intent() {
        return getIntent();
    }

    @Override
    public TextView getName() {
        return findViewById(R.id.seller_name);
    }

    @Override
    public ImageView getAvatar() {
        return findViewById(R.id.seller_image);
    }
}