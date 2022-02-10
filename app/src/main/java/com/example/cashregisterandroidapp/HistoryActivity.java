package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView purchase_list = findViewById(R.id.product_list);
        PurchaseBaseAdapter adapter = new PurchaseBaseAdapter(((MyApp)getApplication()).purchaseManager.getPurchased(), this);
        purchase_list.setAdapter(adapter);

        purchase_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                ((MyApp)getApplication()).mainPurchase = (Purchase)adapter.getItem(pos);
                startActivity(new Intent(parent.getContext(), HistoryDetailsActivity.class));
            }
        });
    }
}