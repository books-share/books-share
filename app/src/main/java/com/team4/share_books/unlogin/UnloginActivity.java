package com.team4.share_books.unlogin;

import android.content.Context;
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
import com.team4.share_books.unlogin.fragment.ExperienceFragment;
import com.team4.share_books.unlogin.fragment.HomeFragment;
import com.team4.share_books.unlogin.fragment.MessageFragment;
import com.team4.share_books.unlogin.fragment.ProfileFragment;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;


public class UnloginActivity extends AppCompatActivity {

    private static final int HOME_FRAGMENT = 0X001;
    private static final int MESSAGE_FRAGMENT = 0X002;
    private static final int DISCOVERY_FRAGMENT = 0X004;
    private static final int PROFILE_FRAGMENT = 0X005;

    private int mCurrentIndex;
    private Context mContext;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private ExperienceFragment mExperienceFragment;
    private ProfileFragment mProfileFragment;

    private FragmentManager mFragmentManager;


    private RelativeLayout mHomeTab, mMessageTab, mExperienceTab, mProfile;
    private ImageView mPostTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlogin_main_activity_layout);
        mContext = this;
        Log.d("onSuccess","init");

        RongIM.init(this);

        RongIM.connect("IxBl9WmwB58ESuhH6nJQTmG+y6HMLM5pAqIkTANGAv47dFQUfArw+d0ixOUoJRRMleD2UpfSxKhcZ/xb3sybx626iTiv2C7I",
                new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.d("onSuccess","user id : " + s);

                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Log.d("onError","onError" + errorCode);
                    }
                });

        mHomeTab = (RelativeLayout) findViewById(R.id.tv_home);
        mMessageTab = (RelativeLayout) findViewById(R.id.tv_message);
        mExperienceTab = (RelativeLayout) findViewById(R.id.tv_experience);
        mProfile = (RelativeLayout) findViewById(R.id.tv_profile);
        mPostTab = (ImageView) findViewById(R.id.fl_post);

        mFragmentManager = getSupportFragmentManager();
        setTabFragment(HOME_FRAGMENT);
        setUpListener();
    }

    private void setTabFragment(int index) {
        if (mCurrentIndex != index) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            hideAllFragments(transaction);
            switch (index) {
                case HOME_FRAGMENT:
                    mHomeTab.setSelected(true);
                    if (mHomeFragment == null) {
                        mHomeFragment = new HomeFragment();
                        transaction.add(R.id.contentLayout, mHomeFragment);

                    } else {
                        transaction.show(mHomeFragment);
                    }
                    mCurrentIndex = HOME_FRAGMENT;
                    break;
                case MESSAGE_FRAGMENT:
                    mMessageTab.setSelected(true);
                    if (mMessageFragment == null) {
                        mMessageFragment = new MessageFragment();
                        transaction.add(R.id.contentLayout, mMessageFragment);

                    } else {
                        transaction.show(mMessageFragment);
                    }
                    mCurrentIndex = MESSAGE_FRAGMENT;
                    break;

                case DISCOVERY_FRAGMENT:
                    mExperienceTab.setSelected(true);
                    if (mExperienceFragment == null) {
                        mExperienceFragment = new ExperienceFragment();
                        transaction.add(R.id.contentLayout, mExperienceFragment);
                    } else {
                        transaction.show(mExperienceFragment);
                    }
                    mCurrentIndex = DISCOVERY_FRAGMENT;
                    break;
                case PROFILE_FRAGMENT:
                    mProfile.setSelected(true);
                    if (mProfileFragment == null) {
                        mProfileFragment = new ProfileFragment();
                        transaction.add(R.id.contentLayout, mProfileFragment);
                    } else {
                        transaction.show(mProfileFragment);
                    }
                    mCurrentIndex = PROFILE_FRAGMENT;
                    break;
            }
            transaction.commit();
        } else if (mCurrentIndex == HOME_FRAGMENT && mHomeFragment != null) {

        }
    }

    private void hideAllFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }

        if (mExperienceFragment != null) {
            transaction.hide(mExperienceFragment);
        }
        if (mProfileFragment != null) {
            transaction.hide(mProfileFragment);
        }
        mHomeTab.setSelected(false);
        mMessageTab.setSelected(false);
        mExperienceTab.setSelected(false);
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
                Toast.makeText(mContext, "请先登录", Toast.LENGTH_SHORT).show();
            }
        });
        mExperienceTab.setOnClickListener(new View.OnClickListener() {
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
