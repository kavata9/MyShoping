package com.github.kavata9.myshoping.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kavata9.myshoping.R;
import com.github.kavata9.myshoping.models.Item;
import com.github.kavata9.myshoping.ui.ShoppingDetailActivity;
import com.github.kavata9.myshoping.ui.ShoppingDetailFragment;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder> {

    private List<Item> mItem = new ArrayList<>();
    private Context mContext;

    public ShoppingListAdapter(Context context, List<Item> item) {
        mContext = context;
        mItem = item;
    }
    @Override
    public ShoppingListAdapter.ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_item, parent, false);
        ShoppingViewHolder viewHolder = new ShoppingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingListAdapter.ShoppingViewHolder holder, int position) {
        holder.bindProducut(mItem.get(position));
    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }


    public class ShoppingViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        @BindView(R.id.ImageView) ImageView mImageView;
        @BindView(R.id.productNameTextView) TextView mNameTextView;
        @BindView(R.id.salePriceTextView) TextView mSalePriceTextView;
        @BindView(R.id.customerRatingTextView) TextView mRatingTextView;

        private Context mContext;

        public ShoppingViewHolder(View itemView) {


            super(itemView);
            ButterKnife.bind(this, itemView);


            mContext = itemView.getContext();

            itemView.setOnClickListener(this);

        }

            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, ShoppingDetailActivity.class);
                intent.putExtra("position", itemPosition);
                intent.putExtra("item", Parcels.wrap(mItem));
                mContext.startActivity(intent);
            }

        public void bindProducut(Item item) {

            Picasso.with(mContext).load(item.getMediumImage()).into(mImageView);

            mNameTextView.setText(item.getName());
            mSalePriceTextView.setText("Price: " + item.getSalePrice() + "/5");
            mRatingTextView.setText( item.getCustomerRating());
        }
    }
}
