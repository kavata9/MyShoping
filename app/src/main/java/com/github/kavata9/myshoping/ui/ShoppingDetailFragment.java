package com.github.kavata9.myshoping.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.models.Item;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingDetailFragment extends Fragment {


    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @BindView(R.id.ImageView)
    ImageView mImageLabel;
    @BindView(R.id.productNameTextView)
    TextView mNameLabel;
    @BindView(R.id.salePriceTextView)
    TextView msalePriceLabel;
    @BindView(R.id.CustomerRatingTextView)
    TextView mRatingLabel;
    @BindView(R.id.saveShoppingButton)
    TextView mSaveShoppingButton;

    private Item mItem;

    public static android.support.v4.app.Fragment newInstance(Item item) {
        ShoppingDetailFragment shoppingDetailFragment = new ShoppingDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("item", Parcels.wrap(item));
        shoppingDetailFragment.setArguments(args);
        return shoppingDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItem = Parcels.unwrap(getArguments().getParcelable("item"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mItem.getMediumImage())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);


        mNameLabel.setText(mItem.getName());
        mRatingLabel.setText((mItem.getCustomerRating()));
        msalePriceLabel.setText((mItem.getSalePrice() + "/5"));


        return view;
    }


    
}

