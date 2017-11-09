package com.team4.share_books.login.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team4.share_books.R;
import com.team4.share_books.entities.BookEntity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 17/11/7.
 */

public class HomepageListAdapter extends RecyclerView.Adapter {

    private List<BookEntity> mDataSet = new ArrayList<>();
    private OnItemClickListenter mOnItemClickListenter;
    private Context mContext;


    public HomepageListAdapter(List<BookEntity> dataSet, Context context) {
        mDataSet = dataSet;
        mContext = context;


    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_comment, parent, false);
        return new HomepageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HomepageViewHolder) {
            final BookEntity b = mDataSet.get(position);
            HomepageViewHolder homepageViewholder = (HomepageViewHolder) holder;
            homepageViewholder.nameTx.setText(b.getAvailable());
            homepageViewholder.detailTx.setText(b.getName());
            homepageViewholder.numTx.setText(b.getStatus());
            homepageViewholder.booknameTx.setText(b.getName());
            homepageViewholder.authorTx.setText(b.getName());
            homepageViewholder.newPriceTx.setText("43");
            Glide.with(mContext).load(R.raw.bg_mine).asBitmap().into(homepageViewholder.bookImg);

        }

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setOnItemClickListener (OnItemClickListenter listener) {
        mOnItemClickListenter = listener;
    }

    public interface OnItemClickListenter {
        void onItemClick (View v, int position);
    }

    class HomepageViewHolder extends RecyclerView.ViewHolder {
        private ImageView markImg;
        private ImageView iconImg;
        private TextView nameTx;
        private TextView detailTx;
        private TextView numTx;
        private ImageView bookImg;
        private TextView booknameTx;
        private TextView authorTx;
        private TextView newPriceTx;

        public HomepageViewHolder(View itemView) {
            super(itemView);
            initialize(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (mOnItemClickListenter != null) {
                        mOnItemClickListenter.onItemClick(view, getLayoutPosition());
                    }
                }
            });
        }

        private void initialize(View v) {
            markImg = (ImageView) v.findViewById(R.id.markImg);
            iconImg = (ImageView) v.findViewById(R.id.iconImg);
            nameTx = (TextView) v.findViewById(R.id.nameTx);
            detailTx = (TextView) v.findViewById(R.id.detailTx);
            numTx = (TextView) v.findViewById(R.id.numTx);
            bookImg = (ImageView) v.findViewById(R.id.bookImg);
            booknameTx = (TextView) v.findViewById(R.id.booknameTx);
            authorTx = (TextView) v.findViewById(R.id.authorTx);
            newPriceTx = (TextView) v.findViewById(R.id.newPriceTx);
        }
    }


}
