package com.example.cashregisterandroidapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int id;
    private String name;
    private int qty;
    private double price;

    public Product() {}

    public Product(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setQty(int newQty) {
        this.qty = newQty;
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.qty = in.readInt();
        this.price = in.readDouble();
    }

    @Override
    public String toString() {
        return this.id + " | " + this.name + " | " + this.qty + " | " + this.price;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }
        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.qty);
        parcel.writeDouble(this.price);
    }
}
