package com.team4.share_books.unlogin.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team4.share_books.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends Fragment {

    private View mView;

    public ExperienceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.unlogin_experiencefragemtn_layout, container,false);
        return mView;
    }

}
