package com.market.leafandroid.sellers;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.market.leafandroid.R;

import java.util.LinkedList;

public class SellerListAdapter extends RecyclerView.Adapter<SellerListAdapter.ViewHolder> {
    private LinkedList<Seller> sellers;

    @NonNull
    @Override
    public SellerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerListAdapter.ViewHolder holder, int position) {
        Seller seller = sellers.get(position);
        holder.setImage(seller.getImage());
        holder.setName(seller.getName());
    }

    @Override
    public int getItemCount() {
        return sellers.size();
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
        notifyItemChanged(getItemCount()-1);
    }

    public void addAllSellers(LinkedList<Seller> sellers) {
        int prevSize = getItemCount();
        sellers.addAll(sellers);
        notifyItemChanged(prevSize, sellers.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(@NonNull ViewGroup parent) {
            this(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.seller_item_view, parent, false));
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }

        public View getView() {
            return view;
        }

        public void setImage(String url) {
            ((ImageView) view.findViewById(R.id.seller_image)).setImageURI(Uri.parse("https://avatars.mds.yandex.net/i?id=cd8a22d2654a355fa64363e141b450ec_l-4073135-images-thumbs&n=13"));
        }

        public void setName(String name) {
            ((TextView) view.findViewById(R.id.seller_name)).setText(name);
        }
    }
}
