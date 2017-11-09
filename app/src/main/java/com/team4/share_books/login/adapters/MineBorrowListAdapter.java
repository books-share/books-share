package com.team4.share_books.login.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team4.share_books.R;
import com.team4.share_books.entities.BookEntity;
import com.team4.share_books.entities.BorrowEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 17/11/8.
 */

public class MineBorrowListAdapter extends RecyclerView.Adapter {

    private List<BorrowEntity> mDataSet = new ArrayList<>();
    private HomepageListAdapter.OnItemClickListenter mOnItemClickListenter;
    private Context mContext;


    public MineBorrowListAdapter(List<BorrowEntity> dataSet, Context context) {
        mDataSet = dataSet;
        mContext = context;
//        setmData();


    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_borrow, parent, false);
        return new MineBorrowListAdapter.MineBorrowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MineBorrowListAdapter.MineBorrowViewHolder) {
            final BorrowEntity b = mDataSet.get(position);
            Log.d("TAG",Integer.toString(mDataSet.size()));
            MineBorrowListAdapter.MineBorrowViewHolder mineBorrowViewHolder = (MineBorrowListAdapter.MineBorrowViewHolder) holder;
            mineBorrowViewHolder.bookname.setText(b.getBookname());
            mineBorrowViewHolder.bookauthor.setText(b.getBookauthor());
            mineBorrowViewHolder.date.setText(b.getDate());

            Glide.with(mContext).load(R.raw.bg_mine).asBitmap().into(mineBorrowViewHolder.bookImg);

        }

    }

    private void setmData(){
        for (int i = 0 ; i < 8; i++){
            BorrowEntity entity = new BorrowEntity("name" + i, "author" + i, "2017-3-2");
            mDataSet.add(entity);
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setOnItemClickListener (HomepageListAdapter.OnItemClickListenter listener) {
        mOnItemClickListenter = listener;
    }

    public interface OnItemClickListenter {
        void onItemClick (View v, int position);
    }

    class MineBorrowViewHolder extends RecyclerView.ViewHolder {
        private ImageView bookImg;
        private TextView bookname;
        private TextView bookauthor;
        private TextView date;


        public MineBorrowViewHolder(View itemView) {
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
            bookImg = (ImageView) v.findViewById(R.id.bookImgB);
            bookname = (TextView) v.findViewById(R.id.bookNameB);
            bookauthor = (TextView) v.findViewById(R.id.authorTB);
            date = (TextView) v.findViewById(R.id.returndateTx);

        }
    }


}
