package com.github.kavata9.myshoping.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.adapters.ShoppingPagerAdapter;
import com.github.kavata9.myshoping.models.Item;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private ShoppingPagerAdapter adapterViewPager;
    List<Item> mItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_detail);
        ButterKnife.bind(this);

        mItem = Parcels.unwrap(getIntent().getParcelableExtra("item"));

        int startingPosition = (getIntent().getIntExtra("position",0));

        adapterViewPager = new ShoppingPagerAdapter(getSupportFragmentManager(), mItem);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}


