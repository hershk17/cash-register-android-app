package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView product_list = findViewById(R.id.product_list);
        PurchaseBaseAdapter adapter = new PurchaseBaseAdapter(((MyApp)getApplication()).purchaseManager.getPurchased(), this);
        product_list.setAdapter(adapter);
    }
}