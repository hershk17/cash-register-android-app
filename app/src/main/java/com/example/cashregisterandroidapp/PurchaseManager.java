package com.example.cashregisterandroidapp;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseManager {
    private final ArrayList<Purchase> purchased = new ArrayList<>();

    public void addPurchase(Product product, int purchasedQty, double totalPrice){
        purchased.add(new Purchase(product, purchasedQty, totalPrice, new Date()));
    }

    public ArrayList<Purchase> getPurchased() {
        return this.purchased;
    }
}
