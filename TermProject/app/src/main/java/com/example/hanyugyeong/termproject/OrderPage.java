package com.example.hanyugyeong.termproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setTitle("Order");
        setContentView(R.layout.activity_order_page);
    }
}
