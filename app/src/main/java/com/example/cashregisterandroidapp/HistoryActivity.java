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