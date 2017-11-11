package com.example.asus.trendhimapp.shoppingCartActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.trendhimapp.R;
import com.example.asus.trendhimapp.categoryPage.CategoryProduct;
import com.example.asus.trendhimapp.mainActivities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends BaseActivity {
    private static TextView subtotalTextView, shippingTextView, totalTextView;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
    }

    private void initializeComponents() {
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_shopping_cart, null, false);
        BaseActivity.drawer.addView(contentView, 0);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setTitle(R.string.shopping_cart_title);

        subtotalTextView = findViewById(R.id.subtotal_value_text_view);
        shippingTextView = findViewById(R.id.shipping_value_text_view);
        totalTextView = findViewById(R.id.grand_total_value_text_view);

        checkoutButton = findViewById(R.id.checkout_button);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCredentials = new Intent();
                Toast.makeText(ShoppingCartActivity.this, "UNIMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        // Setup the recycler view
        RecyclerView recyclerView = findViewById(R.id.the_recycler_view);
        List<CategoryProduct> shoppingCartProducts = new ArrayList<>();
        ShoppingCartAdapter adapter = new ShoppingCartAdapter(this, shoppingCartProducts);
        recyclerView.setAdapter(adapter);
        adapter.populateRecyclerView();

        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
    }

    @SuppressLint("SetTextI18n")
    public static void setSubtotal(int newSubtotal) {
        subtotalTextView.setText(String.valueOf(newSubtotal) + "€");
    }

    /**
     * @return the subtotal cost
     **/
    public static int getSubtotalCost() {
        String value = subtotalTextView.getText().toString();
        value = value.replace("€", ""); // Get rid of the euro sign
        return Integer.parseInt(value);
    }

    @SuppressLint("SetTextI18n")
    public static void setShippingCost(int shippingCost) {
        shippingTextView.setText(String.valueOf(shippingCost) + "€");
    }

    /**
     * @return the shipping cost
     **/
    public static int getShippingCost() {
        String value = shippingTextView.getText().toString();
        value = value.replace("€", ""); // Get rid of the euro sign
        return Integer.parseInt(value);
    }

    @SuppressLint("SetTextI18n")
    public static void setGrandTotalCost(int totalCost) {
        totalTextView.setText(String.valueOf(totalCost) + "€");
    }

    /**
     * @return the grand total cost
     **/
    public static int getGrandTotalCost() {
        String value = totalTextView.getText().toString();
        value = value.replace("€", ""); // Get rid of the euro sign
        return Integer.parseInt(value);
    }

}
