package com.team4.share_books.login.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.team4.share_books.R;

/**
 * Created by john on 17/11/7.
 */

public class BaseFragment extends Fragment {

    @Override
    public void startActivity(Intent intent) {
//        super.startActivity(intent);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.anmi_in_right_left, R.anim.anmi_out_right_left);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
//        super.startActivityForResult(intent, requestCode);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.anmi_in_right_left, R.anim.anmi_out_right_left);
    }
}
