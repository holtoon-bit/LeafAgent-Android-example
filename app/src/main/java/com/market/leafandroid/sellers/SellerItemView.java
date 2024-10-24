package com.market.leafandroid.sellers;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.market.leafandroid.R;

public class SellerItemView extends FrameLayout {
    private Seller seller;
    private String defaultImage = "https://www.amag.ru/lib/images/avatar.jpg";

    public SellerItemView(Context context) {
        super(context);
        inflate(getContext(), R.layout.seller_item_view, this);
        getImageView().setImageURI(Uri.parse(defaultImage));
        setOnClickListener((v) -> openProfile());
    }

    public SellerItemView(Context context, Seller seller) {
        this(context);
        setInfo(seller);
    }

    public void setInfo(Seller seller) {
        this.seller = seller;
    }

    public ImageView getImageView() {
        return findViewById(R.id.seller_image);
    }

    public TextView getNameView() {
        return findViewById(R.id.seller_name);
    }

    public void openProfile() {

    }
}
