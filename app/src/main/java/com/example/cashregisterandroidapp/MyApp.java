package com.example.cashregisterandroidapp;

import android.app.Application;

public class MyApp extends Application {
    ProductManager productManager = new ProductManager();
    Product mainProduct = new Product();
    int mainSelectedQty = 0;

    PurchaseManager purchaseManager = new PurchaseManager();
    Purchase mainPurchase = new Purchase();

    Product restockingProduct = new Product();
    int restockingQty = 0;
}
