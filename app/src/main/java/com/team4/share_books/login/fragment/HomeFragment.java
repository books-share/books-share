package com.team4.share_books.login.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.team4.share_books.R;
import com.team4.share_books.entities.BookEntity;
import com.team4.share_books.login.activity.MainActivity;
import com.team4.share_books.login.activity.MineBorrowActivity;
import com.team4.share_books.login.adapters.HomepageListAdapter;
import com.team4.share_books.login.presenter.HomePresenter;
import com.team4.share_books.login.presenter.imp.HomePresenterImp;
import com.team4.share_books.login.view.HomeView;
import com.team4.share_books.login.view.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 17/11/7.
 */

public class HomeFragment extends BaseFragment implements HomeView {
    private PullToRefreshRecyclerView rlv;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private HomePresenter mPresenter;
    private HomepageListAdapter mListAdapter;
    List<BookEntity> mList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenterImp(this);
        mList = new ArrayList<>();
        for(int i= 0; i < 10; i++){
            BookEntity b1 = new BookEntity("手动阀咖啡" + " " + i,"家酸辣粉；安抚","家里舒服；简单；阿里附近啊","沙发发","按时发放");
            mList.add(b1);
       }

        mListAdapter = new HomepageListAdapter(mList,getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        rlv = (PullToRefreshRecyclerView) inflater.inflate(R.layout.login_homefragment, container, false);
        View view = inflater.inflate(R.layout.login_homefragment, null);
        rlv = view.findViewById(R.id.mylist);
        init();
        mPresenter.loadData();
        return view;
    }

    private void init() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        rlv.getRefreshableView().setLayoutManager(mLayoutManager);
        mItemDecoration = new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        rlv.addItemDecoration(mItemDecoration);
        rlv.setAdapter(mListAdapter);
        rlv.setMode(PullToRefreshBase.Mode.BOTH);
        rlv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                mPresenter.loadData();
            }

            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                mPresenter.loadMore();
            }
        });
        mListAdapter.setOnItemClickListener(new HomepageListAdapter.OnItemClickListenter() {
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), MineBorrowActivity.class);
//                intent.putExtra(BookEntity.class.getSimpleName(),mList.get(position));
                startActivity(intent);

                Log.d("buteyi","点击了ItemClick按钮");
                Log.d("buteyi","HomeFragment中的position:"+position);
//                showNormalDialog();


            }
        });

    }

    private void showNormalDialog() {
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(getActivity());
//        normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();

    }


    @Override
    public void onError(String error) {

    }

    @Override
    public void onSuccess(List<BookEntity> list) {
        rlv.onRefreshComplete();
        mList.clear();
        mList.addAll(list);
        mListAdapter.notifyDataSetChanged();

    }
}
