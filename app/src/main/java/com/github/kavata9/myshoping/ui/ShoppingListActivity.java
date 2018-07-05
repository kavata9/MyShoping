package com.github.kavata9.myshoping.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.adapters.ShoppingListAdapter;
import com.github.kavata9.myshoping.models.Item;
import com.github.kavata9.myshoping.services.WalMartService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class ShoppingListActivity extends Activity {
    public static final String TAG = ShoppingListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private ShoppingListAdapter mAdapter;

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

                ShoppingListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new ShoppingListAdapter(getApplicationContext(), products);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(ShoppingListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
