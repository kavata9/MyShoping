package com.github.kavata9.myshoping.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kavata9.myshoping.Constants;
import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.models.Item;
import com.github.kavata9.myshoping.ui.ShoppingDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseShoppingViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindShopping(Item item) {
        ImageView ImageView = (ImageView) mView.findViewById(R.id.ImageView);
        TextView ProductNameTextView = (TextView) mView.findViewById(R.id.productNameTextView);
        TextView SalePriceTextView = (TextView) mView.findViewById(R.id.salePriceTextView);
        TextView CustomerratingTextView = (TextView) mView.findViewById(R.id.CustomerRatingTextView);

        Picasso.with(mContext)
                .load(item.getMediumImage())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(ImageView);

        ProductNameTextView.setText(item.getName());
        SalePriceTextView.setText(item.getSalePrice() + "/5");
        CustomerratingTextView.setText(item.getCustomerRating());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Item> item = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PRODUCTS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    item.add(snapshot.getValue(Item.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ShoppingDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("item", Parcels.wrap(item));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}