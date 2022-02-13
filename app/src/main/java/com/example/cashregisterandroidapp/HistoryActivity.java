package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HistoryActivity extends AppCompatActivity implements PurchaseRecycleAdapter.ItemClickListener {

    PurchaseRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

//        ListView purchase_list = findViewById(R.id.product_list);
//        PurchaseBaseAdapter adapter = new PurchaseBaseAdapter(((MyApp)getApplication()).purchaseManager.getPurchased(), this);
//        purchase_list.setAdapter(adapter);
//
//        purchase_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
//                ((MyApp)getApplication()).mainPurchase = (Purchase)adapter.getItem(pos);
//                startActivity(new Intent(parent.getContext(), HistoryDetailsActivity.class));
//            }
//        });

        RecyclerView recyclerView = findViewById(R.id.product_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PurchaseRecycleAdapter(((MyApp)getApplication()).purchaseManager.getPurchased(), this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onItemClick(View view, int position) {
        ((MyApp)getApplication()).mainPurchase = (Purchase)adapter.getItem(position);
        startActivity(new Intent(view.getContext(), HistoryDetailsActivity.class));
    }
}