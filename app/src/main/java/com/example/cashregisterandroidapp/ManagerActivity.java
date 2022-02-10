package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    Button history_btn, restock_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        this.history_btn = findViewById(R.id.history_btn);
        this.restock_btn = findViewById(R.id.restock_btn);

        this.history_btn.setOnClickListener(this);
        this.restock_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.history_btn:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.restock_btn:
                startActivity(new Intent(this,Restock.class));
                break;
            default:
                break;
        }
    }
}