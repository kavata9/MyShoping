package com.github.kavata9.myshoping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingActivity extends Activity {
    @BindView(R.id.productTextView) TextView mProductTextView;
    @BindView(R.id.listView) ListView mListView;


    private String[] products = new String[] {""};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.listView);
        mProductTextView = (TextView) findViewById(R.id.productTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, products);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String products = ((TextView)view).getText().toString();
                Toast.makeText(ShoppingActivity.this, products, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
    }

}
