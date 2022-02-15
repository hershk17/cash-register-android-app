package com.example.cashregisterandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener {

    private Product currProduct;
    ProductBaseAdapter adapter;
    EditText qtyInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        ListView product_list = findViewById(R.id.product_list);
        adapter = new ProductBaseAdapter(((MyApp)getApplication()).productManager.getProducts(), this);
        product_list.setAdapter(adapter);

        qtyInput = findViewById(R.id.qty_input);

        product_list.setOnItemClickListener((parent, view, pos, id) -> {
            currProduct = (Product)adapter.getItem(pos);
            ((MyApp)getApplication()).restockingProduct = currProduct;
            ((TextView)findViewById(R.id.selected_product)).setText(getString(R.string.selected_product, currProduct.getName()));
        });

        qtyInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(!String.valueOf(qtyInput.getText()).isEmpty()) {
                    ((MyApp)getApplication()).restockingQty = Integer.parseInt(String.valueOf(qtyInput.getText()));
                }
                else {
                    ((MyApp)getApplication()).restockingQty = 0;
                }
            }
        });

        if(((MyApp)getApplication()).restockingProduct.getId() != -1) {
            currProduct = ((MyApp)getApplication()).restockingProduct;
            ((TextView)findViewById(R.id.selected_product)).setText(getString(R.string.selected_product, currProduct.getName()));
            qtyInput.setText(String.valueOf(((MyApp)getApplication()).restockingQty));
        }

        findViewById(R.id.restock_confirm).setOnClickListener(this);
        findViewById(R.id.restock_cancel).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id) {
            case R.id.restock_confirm:
                String input = qtyInput.getText().toString();
                if(currProduct == null) {
                    Toast.makeText(getApplicationContext(), "Please select a product!", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(input)) {
                    Toast.makeText(getApplicationContext(), "Please enter a quantity to restock!", Toast.LENGTH_SHORT).show();
                }
                else {
                    ((MyApp)getApplication()).productManager.updateQty(currProduct.getId(), Integer.parseInt(input) + currProduct.getQty());
                    adapter.notifyDataSetChanged();
                    qtyInput.setText("");
                    currProduct = null;
                    ((TextView)findViewById(R.id.selected_product)).setText(R.string.not_selected_product);
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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}