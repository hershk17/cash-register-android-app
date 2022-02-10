package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProductManager productManager;
    private Product product;

//    private AlertDialog.Builder builder;

    private TextView product_type, product_qty, product_total;
    private Button manager_btn, buy_btn;
    private NumberPicker qty_picker;
    private ListView product_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        builder = new AlertDialog.Builder(this);

        product_type = findViewById(R.id.product_type);
        product_qty = findViewById(R.id.product_qty);
        product_total = findViewById(R.id.product_total);
        qty_picker = findViewById(R.id.qty_picker);
        manager_btn = findViewById(R.id.manager_btn);
        buy_btn = findViewById(R.id.buy_btn);

        manager_btn.setOnClickListener(this);
        buy_btn.setOnClickListener(this);

        product = ((MyApp)getApplication()).mainProduct;
        productManager = ((MyApp)getApplication()).manager;

        product_list = findViewById(R.id.product_list);
        ProductBaseAdapter adapter = new ProductBaseAdapter(((MyApp)getApplication()).manager.getProducts(), this);
        product_list.setAdapter(adapter);



//        product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id) {
            case R.id.manager_btn:
                startActivity(new Intent(this,Manager.class));
                break;
            case R.id.buy_btn:
                productManager.addPurchase(product);
                ((MyApp)getApplication()).mainProduct = new Product();
                product = ((MyApp)getApplication()).mainProduct;
                break;
            default:
                break;
        }
    }
}