package com.example.cashregisterandroidapp;

import java.util.Date;

public class Purchase {
    private final Product product;
    private final int purchaseQty;
    private final double purchasePrice;
    private final Date dateOfPurchase;

    public Purchase() {
        this.product = null;
        this.purchaseQty = -1;
        this.purchasePrice = -1;
        this.dateOfPurchase = null;
    }

    public Purchase(Product product, int purchaseQty, double purchasePrice, Date dateOfPurchase) {
        this.product = product;
        this.purchaseQty = purchaseQty;
        this.purchasePrice = purchasePrice;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getPurchaseQty() {
        return this.purchaseQty;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public Date getDateOfPurchase() {
        return this.dateOfPurchase;
    }
}
