package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProductManager productManager;
    private Product product;

    private AlertDialog.Builder builder;

    private TextView product_type, product_qty, product_total;
    private Button manager_btn, buy_btn;
    private NumberPicker qty_picker;
    private ListView product_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.builder = new AlertDialog.Builder(this);

        this.product_type = findViewById(R.id.product_type);
        this.product_qty = findViewById(R.id.product_qty);
        this.product_total = findViewById(R.id.product_total);
        this.qty_picker = findViewById(R.id.qty_picker);
        this.manager_btn = findViewById(R.id.manager_btn);
        this.buy_btn = findViewById(R.id.buy_btn);

        this.manager_btn.setOnClickListener(this);
        this.buy_btn.setOnClickListener(this);

        this.product = ((MyApp)getApplication()).product;
        this.productManager = ((MyApp)getApplication()).manager;

        this.product_list = findViewById(R.id.product_list);
        ArrayAdapter<Product> adapter = new ArrayAdapter<>(this, R.layout.product_row_layout, R.id.product_row, productManager.getProducts());
        this.product_list.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id) {
            case R.id.manager_btn:
                Intent intent = new Intent(this,Manager.class);
                startActivity(intent);
                break;
            case R.id.buy_btn:
                this.productManager.addPurchase(this.product);
                this.product = new Product();
                break;
            default:
                break;
        }
    }
}