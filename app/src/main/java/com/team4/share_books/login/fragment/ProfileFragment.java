package com.team4.share_books.login.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team4.share_books.R;
import com.team4.share_books.entities.UserEntity;
import com.team4.share_books.login.activity.LoginActivity;
import com.team4.share_books.login.activity.MineBorrowActivity;
import com.team4.share_books.login.view.ProfileView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment implements ProfileView {

    private View mView;
    private ImageView iconImg;
    private TextView nameTx;
    private RelativeLayout rongyuRt, jieruRt , jiechuRt;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_mine, container, false);
        iconImg = (ImageView) mView.findViewById(R.id.iconImg);
        nameTx = (TextView) mView.findViewById(R.id.nameTx);
        rongyuRt = (RelativeLayout) mView.findViewById(R.id.rongyuRt);
        jiechuRt = (RelativeLayout) mView.findViewById(R.id.jiechuRt);
        jieruRt = (RelativeLayout) mView.findViewById(R.id.jieruRt);
        rongyuRt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        jiechuRt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });
        jieruRt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MineBorrowActivity.class);
                startActivity(intent);

            }
        });
        return mView;
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void updataView(UserEntity userEntity) {

    }
}
