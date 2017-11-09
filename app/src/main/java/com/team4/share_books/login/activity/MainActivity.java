package com.team4.share_books.login.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.team4.share_books.R;
import com.team4.share_books.login.fragment.ExperienceFragment;
import com.team4.share_books.login.fragment.HomeFragment;
import com.team4.share_books.login.fragment.MessageFragment;
import com.team4.share_books.login.fragment.ProfileFragment;


public class MainActivity extends AppCompatActivity {
    private static final String HOME_FRAGMENT = "home";
    private static final String MESSAGE_FRAGMENT = "message";
    private static final String DISCOVERY_FRAGMENT = "discover";
    private static final String PROFILE_FRAGMENT = "profile";

    private String mCurrentIndex;
    private Context mContext;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private ExperienceFragment mDiscoverFragment;
    private ProfileFragment mProfileFragment;

    private FragmentManager mFragmentManager;
    FragmentTransaction mTransaction;

    private RelativeLayout mHomeTab, mMessageTab, mDiscoverTab, mProfile;
    private ImageView mPostTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlogin_main_activity_layout);
        mContext = this;
        mHomeTab = (RelativeLayout) findViewById(R.id.tv_home);
        mMessageTab = (RelativeLayout) findViewById(R.id.tv_message);
        mPostTab = (ImageView) findViewById(R.id.fl_post);
        mDiscoverTab = (RelativeLayout) findViewById(R.id.tv_experience);
        mProfile = (RelativeLayout) findViewById(R.id.tv_profile);

        mFragmentManager = getSupportFragmentManager();
        Log.d("buteyi","comeToMainActivity");

        setTabFragment(HOME_FRAGMENT);
        setUpListener();

    }

    //Activity被销毁时,记录当前处于哪个index
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("index", mCurrentIndex);
        super.onSaveInstanceState(outState);
    }

    private void setTabFragment(String index) {
        if (mCurrentIndex != index) {
            mTransaction = mFragmentManager.beginTransaction();
            hideAllFragments(mTransaction);
            switch (index) {
                case HOME_FRAGMENT:
                    mHomeTab.setSelected(true);
                    if (mHomeFragment == null) {

                        mHomeFragment = new HomeFragment();
                        mTransaction.add(R.id.contentLayout, mHomeFragment, HOME_FRAGMENT);

                    } else {
                        mTransaction.show(mHomeFragment);

                    }
                    mCurrentIndex = HOME_FRAGMENT;
                    break;
                case MESSAGE_FRAGMENT:
                    mMessageTab.setSelected(true);
                    if (mMessageFragment == null) {
                        mMessageFragment = new MessageFragment();
                        mTransaction.add(R.id.contentLayout, mMessageFragment, MESSAGE_FRAGMENT);

                    } else {
                        mTransaction.show(mMessageFragment);
                    }
                    mCurrentIndex = MESSAGE_FRAGMENT;
                    break;

                case DISCOVERY_FRAGMENT:
                    mDiscoverTab.setSelected(true);
                    if (mDiscoverFragment == null) {
                        mDiscoverFragment = new ExperienceFragment();
                        mTransaction.add(R.id.contentLayout, mDiscoverFragment, DISCOVERY_FRAGMENT);
                    } else {
                        mTransaction.show(mDiscoverFragment);
                    }
                    mCurrentIndex = DISCOVERY_FRAGMENT;
                    break;
                case PROFILE_FRAGMENT:
                    mProfile.setSelected(true);
                    if (mProfileFragment == null) {
                        mProfileFragment = new ProfileFragment();
                        mTransaction.add(R.id.contentLayout, mProfileFragment, PROFILE_FRAGMENT);
                    } else {
                        mTransaction.show(mProfileFragment);
                    }
                    mCurrentIndex = PROFILE_FRAGMENT;
                    break;
            }
            mTransaction.commit();
        }
    }


    private void hideAllFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }

        if (mDiscoverFragment != null) {
            transaction.hide(mDiscoverFragment);
        }
        if (mProfileFragment != null) {
            transaction.hide(mProfileFragment);
        }
        mHomeTab.setSelected(false);
        mMessageTab.setSelected(false);
        mDiscoverTab.setSelected(false);
        mProfile.setSelected(false);
    }

    //设置tabbar的点击监听事件
    private void setUpListener() {
        mHomeTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(HOME_FRAGMENT);

            }
        });
        mMessageTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(MESSAGE_FRAGMENT);
            }
        });
        mPostTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "发书", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext, PostActivity.class);
//                startActivity(intent);

            }
        });
        mDiscoverTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(DISCOVERY_FRAGMENT);

            }
        });
        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(PROFILE_FRAGMENT);
            }
        });
    }



}
