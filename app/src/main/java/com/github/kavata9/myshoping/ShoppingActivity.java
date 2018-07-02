package com.github.kavata9.myshoping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ShoppingActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
    }

}
