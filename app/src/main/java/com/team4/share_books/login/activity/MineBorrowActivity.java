package com.team4.share_books.login.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.team4.share_books.R;
import com.team4.share_books.entities.BorrowEntity;
import com.team4.share_books.login.adapters.MineBorrowListAdapter;
import com.team4.share_books.login.view.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 17/11/8.
 */

public class MineBorrowActivity extends AppCompatActivity {
    private PullToRefreshRecyclerView rlv;
//    private ListView listView;
    private List<BorrowEntity> mData = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private ImageView backImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_borrow_layout);
        rlv = (PullToRefreshRecyclerView) findViewById(R.id.mine_borrow_list);
        setmData();
        Log.d("TAG",Integer.toString(mData.size()));
        mLayoutManager = new LinearLayoutManager(this);
        rlv.getRefreshableView().setLayoutManager(mLayoutManager);
        mItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        rlv.addItemDecoration(mItemDecoration);
        backImg = (ImageView) findViewById(R.id.back);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rlv.setAdapter(new MineBorrowListAdapter(mData, this));
    }


    public int getLayoutId() {
        return 0;
    }

    private void setmData(){
        for (int i = 0 ; i < 18; i++){
            BorrowEntity entity = new BorrowEntity("name" + i, "author" + i, "2017-3-2");
            mData.add(entity);
        }
    }

}
