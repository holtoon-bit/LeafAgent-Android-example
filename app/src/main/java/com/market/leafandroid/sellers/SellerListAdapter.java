package com.market.leafandroid.sellers;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.market.leafandroid.R;

import java.util.LinkedList;

public class SellerListAdapter extends RecyclerView.Adapter<SellerListAdapter.ViewHolder> {
    private LinkedList<Seller> sellers = new LinkedList<>();

    @NonNull
    @Override
    public SellerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent.getContext());
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

    public void addAllSellers(LinkedList<Seller> sellerList) {
        int prevSize = getItemCount();
        sellers.addAll(sellerList);
        notifyItemChanged(prevSize, sellers.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SellerItemView view;

        public ViewHolder(@NonNull SellerItemView itemView) {
            super(itemView);
            view = itemView;
        }

        public ViewHolder(@NonNull Context context) {
            this(new SellerItemView(context));
        }

        public View getView() {
            return view;
        }

        public void setImage(String url) {
            view.getImageView().setImageURI(Uri.parse(url));
        }

        public void setName(String name) {
            view.getNameView().setText(name);
        }
    }
}
