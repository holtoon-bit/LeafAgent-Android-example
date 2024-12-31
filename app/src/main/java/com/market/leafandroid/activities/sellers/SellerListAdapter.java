package com.market.leafandroid.activities.sellers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import com.market.leafandroid.objects.Seller;

import leafagent.annotations.Branch;
import leafagent.annotations.Leaf;

@Branch
public class SellerListAdapter extends RecyclerView.Adapter<SellerListAdapter.ViewHolder> {
    private LinkedList<Seller> sellers = new LinkedList<>();

    public SellerListAdapter() {
    }

    @NonNull
    @Override
    public SellerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull SellerListAdapter.ViewHolder holder, int position) {
        holder.setSeller(sellers.get(position));
    }

    @Override
    public int getItemCount() {
        return sellers.size();
    }

    @Leaf
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

        public void setSeller(Seller seller) {
            view.setInfo(seller);
        }
    }
}
