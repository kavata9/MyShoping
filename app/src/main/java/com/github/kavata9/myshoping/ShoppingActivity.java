package com.github.kavata9.myshoping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShoppingActivity extends Activity {
    private TextView mProductTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        mProductTextView = (TextView) findViewById(R.id.productTextView);
        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
    }

}
