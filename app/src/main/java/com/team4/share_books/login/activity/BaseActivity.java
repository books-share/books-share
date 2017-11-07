package com.team4.share_books.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.team4.share_books.R;

/**
 * Created by john on 17/11/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private RelativeLayout rlContent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_baselayout);
        initialize();
        View v = getLayoutInflater().inflate(getLayoutId(),rlContent, false);
        rlContent.addView(v);
    }

    public abstract int getLayoutId();

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anmi_in_right_left,R.anim.anmi_out_right_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_in_left_right, R.anim.anmi_out_right_left);
    }

    private void initialize() {
        rlContent = (RelativeLayout) findViewById(R.id.rlContent);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }
}
