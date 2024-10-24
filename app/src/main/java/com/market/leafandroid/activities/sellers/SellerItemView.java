package com.market.leafandroid.activities.sellers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.market.leafandroid.R;
import com.market.leafandroid.activities.seller.SellerActivity;
import com.market.leafandroid.objects.Seller;

public class SellerItemView extends FrameLayout {
    private Seller seller;

    public SellerItemView(Context context) {
        super(context);
        inflate(getContext(), R.layout.seller_item_view, this);
        setOnClickListener((v) -> openProfile());
    }

    public SellerItemView(Context context, Seller seller) {
        this(context);
        setInfo(seller);
    }

    public void setInfo(Seller seller) {
        this.seller = seller;
        getNameView().setText(seller.getName());
        getImageView().setImageURI(Uri.parse(seller.getImage()));
    }

    private ImageView getImageView() {
        return findViewById(R.id.seller_image);
    }

    private TextView getNameView() {
        return findViewById(R.id.seller_name);
    }

    public void openProfile() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(getContext(), SellerActivity.class.getName());
        intent.putExtra("seller_id", seller.getId());
        getContext().startActivity(intent);
    }
}
