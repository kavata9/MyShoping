package com.github.kavata9.myshoping.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.models.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder> {

    private List<Item> mProducts = new ArrayList<>();
    private Context mContext;

    public ShoppingListAdapter(Context context, List<Item> products) {
        mContext = context;
        mProducts = products;
    }
    @Override
    public ShoppingListAdapter.ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_item, parent, false);
        ShoppingViewHolder viewHolder = new ShoppingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingListAdapter.ShoppingViewHolder holder, int position) {
        holder.bindProducut(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }


    public class ShoppingViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ImageView) ImageView mImageView;
        @BindView(R.id.productNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryNodeTextView) TextView mCategoryTextView;
        @BindView(R.id.customerRatingTextView) TextView mRatingTextView;

        private Context mContext;

        public ShoppingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindProducut(Item item) {
            mNameTextView.setText(item.getName());
            mCategoryTextView.setText(item.getCategoryNode());
            mRatingTextView.setText("Rating: " + item.getCustomerRating() + "/5");
        }
    }
}


