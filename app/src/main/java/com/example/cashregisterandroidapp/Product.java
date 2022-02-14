package com.example.cashregisterandroidapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Product {
    private final int id;
    private final String name;
    private int qty;
    private final double price;

    public Product() {
        this.id = -1;
        this.name = null;
        this.qty = -1;
        this.price = -1;
    }

    public Product(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQty() {
        return this.qty;
    }

    public double getPrice() {
        return this.price;
    }

    public void setQty(int newQty) {
        this.qty = newQty;
    }
}
