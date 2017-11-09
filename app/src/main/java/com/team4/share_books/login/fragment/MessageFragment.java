package com.team4.share_books.login.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team4.share_books.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private View mView;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.mine_borrow_layout, container, false);
        return mView;
    }

}
