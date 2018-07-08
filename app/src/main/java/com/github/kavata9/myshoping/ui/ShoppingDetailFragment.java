package com.github.kavata9.myshoping.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kavata9.myshoping.Constants;
import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.models.Item;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingDetailFragment extends Fragment  implements View.OnClickListener {


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


        mSaveShoppingButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveShoppingButton) {
            DatabaseReference productRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_PRODUCTS);
            productRef.push().setValue(mItem);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}




