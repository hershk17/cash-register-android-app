package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProductManager productManager;
    private PurchaseManager purchaseManager;
    private Product product;

    private AlertDialog.Builder builder;

    private TextView product_type, product_qty, product_total;
    private NumberPicker qty_picker;

    ProductBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);

        product_type = findViewById(R.id.product_type);
        product_qty = findViewById(R.id.product_qty);
        product_total = findViewById(R.id.product_total);
        findViewById(R.id.manager_btn).setOnClickListener(this);
        findViewById(R.id.buy_btn).setOnClickListener(this);

        product = ((MyApp)getApplication()).mainProduct;
        productManager = ((MyApp)getApplication()).productManager;
        purchaseManager = ((MyApp)getApplication()).purchaseManager;

        ListView product_list = findViewById(R.id.product_list);
        adapter = new ProductBaseAdapter(((MyApp)getApplication()).productManager.getProducts(), this);
        product_list.setAdapter(adapter);

        qty_picker = findViewById(R.id.qty_picker);
        qty_picker.setMinValue(0);

        if(product.getId() != -1) {
            product_type.setText(product.getName());
            qty_picker.setMaxValue(product.getQty());
            qty_picker.setValue(((MyApp)getApplication()).mainSelectedQty);
            product_qty.setText(String.valueOf(((MyApp)getApplication()).mainSelectedQty));
            product_total.setText(String.valueOf(((MyApp)getApplication()).mainSelectedQty * product.getPrice()));
        }

        qty_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                product_qty.setText(String.valueOf(newVal));
                product_total.setText(String.valueOf(product.getPrice() * newVal));
                ((MyApp)getApplication()).mainSelectedQty = newVal;
            }
        });

        product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                ((MyApp)getApplication()).mainProduct = (Product)adapter.getItem(pos);
                product = ((MyApp)getApplication()).mainProduct;
                product_type.setText(product.getName());
                qty_picker.setMaxValue(product.getQty());
                product_qty.setText(String.valueOf(qty_picker.getValue()));
                product_total.setText(String.valueOf(qty_picker.getValue() * product.getPrice()));
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int id = view.getId();

        int qty = qty_picker.getValue();
        double total = qty * product.getPrice();

        switch(id) {
            case R.id.manager_btn:
                startActivity(new Intent(this, ManagerActivity.class));
                break;
            case R.id.buy_btn:
                if(product.getId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select a product!", Toast.LENGTH_SHORT).show();
                }
                else if(qty < 1) {
                    Toast.makeText(getApplicationContext(), "Please select a quantity greater than 0!", Toast.LENGTH_SHORT).show();
                }
                else {
                    purchaseManager.addPurchase(product, qty, total);
                    productManager.updateQty(product.getId(), product.getQty() - qty);
                    adapter.notifyDataSetChanged();
                    builder.setTitle("Success")
                            .setMessage("You purchased " + qty + " " + product.getName() + " for $" + total + ".")
                            .setCancelable(true)
                            .setPositiveButton("OK", null)
                            .show();
                    ((MyApp)getApplication()).mainProduct = new Product();
                    product = ((MyApp)getApplication()).mainProduct;
                    qty_picker.setMaxValue(0);
                    product_type.setText(R.string.product_type);
                    product_qty.setText(R.string.product_qty);
                    product_total.setText(R.string.product_total);
                }
                break;
            default:
                break;
        }
    }
}