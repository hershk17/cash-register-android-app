package com.example.cashregisterandroidapp;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> purchased = new ArrayList<>();

    public ProductManager() {
        products.add(new Product(0, "Pants", 20, 50.7));
        products.add(new Product(1, "Shoes", 50, 90));
        products.add(new Product(2, "Hats", 10, 10));
        products.add(new Product(3, "TShirts", 10, 10));
        products.add(new Product(4, "Dresses", 24, 140.3));
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void addPurchase(Product product){
        purchased.add(product);
    }

    public void updateQty(int id, int newQty) {
        for (Product product : this.products) {
            if (product.getId() == id) {
                product.setQty(newQty);
            }
        }
    }
}
