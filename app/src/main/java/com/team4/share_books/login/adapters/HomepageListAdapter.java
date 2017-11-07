package com.team4.share_books.login.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.team4.share_books.entities.BookEntity;

import java.util.List;

/**
 * Created by john on 17/11/7.
 */

public class HomepageListAdapter extends RecyclerView.Adapter {

    private List<BookEntity> mDataSet;
    private OnItemCLickListenter mOnItemCLickListenter;
    private Context mContext;

    public HomepageListAdapter(List<BookEntity> dataSet, Context context) {
        mDataSet = dataSet;
        mContext = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnItemCLickListenter {
        void onItemClick (View v, int position);
    }
}
