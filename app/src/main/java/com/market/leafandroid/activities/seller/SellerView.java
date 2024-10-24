package com.market.leafandroid.activities.seller;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public interface SellerView {
    Intent intent();
    Context getBaseContext();
    TextView getName();
    ImageView getAvatar();
}
