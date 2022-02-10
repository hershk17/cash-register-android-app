package com.example.cashregisterandroidapp;

import android.app.Application;

public class MyApp extends Application {
    ProductManager productManager = new ProductManager();
    PurchaseManager purchaseManager = new PurchaseManager();
    Product mainProduct = new Product();
}
