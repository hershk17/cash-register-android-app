package com.example.cashregisterandroidapp;

import android.app.Application;

public class MyApp extends Application {
    ProductManager manager = new ProductManager();
    Product product = new Product();
}
