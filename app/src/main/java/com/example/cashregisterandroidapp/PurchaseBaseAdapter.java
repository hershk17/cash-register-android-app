package com.example.cashregisterandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PurchaseBaseAdapter extends BaseAdapter {
    private final ArrayList<Purchase> listOfPurchases;
    private final Context context;

    public PurchaseBaseAdapter(ArrayList<Purchase> listOfPurchases, Context context) {
        this.listOfPurchases = listOfPurchases;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfPurchases.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfPurchases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.product_row_layout, null);

        ((TextView)view.findViewById(R.id.list_product_name)).setText(listOfPurchases.get(i).getProduct().getName());
        ((TextView)view.findViewById(R.id.list_product_price)).setText(String.valueOf(listOfPurchases.get(i).getPurchaseQty()));
        ((TextView)view.findViewById(R.id.list_product_qty)).setText(String.valueOf(listOfPurchases.get(i).getPurchasePrice()));

        return view;
    }
}
