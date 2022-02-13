package com.example.cashregisterandroidapp;

import java.util.ArrayList;
import java.util.Date;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductManager() {
        products.add(new Product(0, "Pants", 20, 50.7));
        products.add(new Product(1, "Shoes", 50, 90));
        products.add(new Product(2, "Hats", 10, 10));
        products.add(new Product(3, "TShirts", 10, 10));
        products.add(new Product(4, "Dresses", 24, 140.3));
        products.add(new Product(5, "Suits", 8, 220));
        products.add(new Product(6, "Jackets", 35, 65));
        products.add(new Product(7, "Shorts", 20, 42.5));
        products.add(new Product(8, "Skirts", 16, 52));
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateQty(int id, int newQty) {
        products.get(id).setQty(newQty);
    }
}
