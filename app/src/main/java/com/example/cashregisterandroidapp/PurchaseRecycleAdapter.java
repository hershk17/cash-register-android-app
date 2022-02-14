package com.example.cashregisterandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PurchaseRecycleAdapter extends RecyclerView.Adapter<PurchaseRecycleAdapter.ViewHolder> {
    private final ArrayList<Purchase> listOfPurchases;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public PurchaseRecycleAdapter(ArrayList<Purchase> listOfPurchases, Context context) {
        this.listOfPurchases = listOfPurchases;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Purchase purchase = listOfPurchases.get(position);

        holder.product_name.setText(purchase.getProduct().getName());
        holder.product_price.setText(String.valueOf(purchase.getPurchaseQty()));
        holder.product_qty.setText(String.valueOf(purchase.getPurchasePrice()));
    }

    @Override
    public int getItemCount() {
        return listOfPurchases.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView product_name, product_price, product_qty;

        ViewHolder(View view) {
            super(view);

            product_name = (TextView)view.findViewById(R.id.list_product_name);
            product_price = (TextView)view.findViewById(R.id.list_product_price);
            product_qty = (TextView)view.findViewById(R.id.list_product_qty);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Purchase getItem(int i) {
        return listOfPurchases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
