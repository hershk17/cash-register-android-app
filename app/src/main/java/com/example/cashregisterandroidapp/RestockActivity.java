package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener {

    private Product currProduct;
    ProductBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        ListView product_list = findViewById(R.id.product_list);
        adapter = new ProductBaseAdapter(((MyApp)getApplication()).productManager.getProducts(), this);
        product_list.setAdapter(adapter);

        product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                currProduct = (Product)adapter.getItem(pos);
            }
        });

        findViewById(R.id.restock_confirm).setOnClickListener(this);
        findViewById(R.id.restock_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id) {
            case R.id.restock_confirm:
                String input = ((EditText)findViewById(R.id.qty_input)).getText().toString();
                if(currProduct == null) {
                    Toast.makeText(getApplicationContext(), "Please select a product!", Toast.LENGTH_SHORT).show();
                }
                else if(input == null) {
                    Toast.makeText(getApplicationContext(), "Please enter a quantity to restock!", Toast.LENGTH_SHORT).show();
                }
                else {
                    ((MyApp)getApplication()).productManager.updateQty(currProduct.getId(), Integer.parseInt(input) + currProduct.getQty());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Restocked!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.restock_cancel:
                finish();
                break;
            default:
                break;
        }
    }
}