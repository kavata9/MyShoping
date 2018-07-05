package com.github.kavata9.myshoping.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.github.kavata9.myshoping.models.Item;
import com.github.kavata9.myshoping.ui.ShoppingDetailFragment;


import java.util.ArrayList;
import java.util.List;


public class ShoppingPagerAdapter extends FragmentPagerAdapter {

    private List<Item> mItem;

    public ShoppingPagerAdapter(FragmentManager fm, List<Item> products) {
        super(fm);
        mItem = products;
    }

  @Override
  public Fragment getItem(int position){
        return ShoppingDetailFragment.newInstance(mItem.get(position));
  }

    @Override
    public int getCount() {
        return mItem.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mItem.get(position).getName();
    }
}

