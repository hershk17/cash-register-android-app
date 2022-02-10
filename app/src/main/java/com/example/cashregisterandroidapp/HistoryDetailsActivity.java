package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HistoryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        ((TextView)findViewById(R.id.purchased_name)).setText(getString(R.string.purchase_label_name, ((MyApp)getApplication()).mainPurchase.getProduct().getName()));
        ((TextView)findViewById(R.id.purchased_qty)).setText(getString(R.string.purchase_label_qty, String.valueOf(((MyApp)getApplication()).mainPurchase.getPurchaseQty())));
        ((TextView)findViewById(R.id.purchased_price)).setText(getString(R.string.purchase_label_total, String.valueOf(((MyApp)getApplication()).mainPurchase.getPurchasePrice())));
        ((TextView)findViewById(R.id.purchased_date)).setText(getString(R.string.purchase_label_date, String.valueOf(((MyApp)getApplication()).mainPurchase.getDateOfPurchase())));
    }
}