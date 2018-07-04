package com.github.kavata9.myshoping.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.models.Item;
import com.github.kavata9.myshoping.models.Items;
import com.github.kavata9.myshoping.services.WalMartService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class ShoppingActivity extends Activity {
    public static final String TAG = ShoppingActivity.class.getSimpleName();

    @BindView(R.id.productTextView) TextView mProductTextView;
    @BindView(R.id.listView) ListView mListView;

    public List<Item> products = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String product = intent.getStringExtra("product");

//        mProductTextView.setText("Here are all the : " + product);

        getProducts(product);
    }

    private void getProducts(String product) {
        final WalMartService walMartService = new WalMartService();
        walMartService.findProducts(product, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
               products = walMartService.result(response);

                ShoppingActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String[] productNames = new String[products.size()];
                        for (int i = 0; i < productNames.length; i++) {
                            productNames[i] = products.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ShoppingActivity.this,
                                android.R.layout.simple_list_item_1, productNames);
                        mListView.setAdapter(adapter);

                        for (Item item : products) {
                            Log.d(TAG, "Name: " + item.getName());
                            Log.d(TAG, "salePrice: " + item.getSalePrice());
                            Log.d(TAG, "productUrl: " + item.getProductUrl());
                            Log.d(TAG, "mediumImage : " + item.getMediumImage());
                            Log.d(TAG, "customerRating: " + item.getCustomerRating());
                            Log.d(TAG, "categoryNode: " + item.getCategoryNode());
                            Log.d(TAG, "availableOnline: " + item.getAvailableOnline().toString());
                        }
                    }
                });
            }
        });
    }
}

