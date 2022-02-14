package com.example.cashregisterandroidapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {

    private final ArrayList<Product> listOfProducts;
    private final Context context;

    public ProductBaseAdapter(ArrayList<Product> listOfProducts, Context context) {
        this.listOfProducts = listOfProducts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.product_row_layout, null);

        ((TextView)view.findViewById(R.id.list_product_name)).setText(listOfProducts.get(i).getName());
        ((TextView)view.findViewById(R.id.list_product_price)).setText(String.valueOf(listOfProducts.get(i).getPrice()));
        ((TextView)view.findViewById(R.id.list_product_qty)).setText(String.valueOf(listOfProducts.get(i).getQty()));

        return view;
    }
}
