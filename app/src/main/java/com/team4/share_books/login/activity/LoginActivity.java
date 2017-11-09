package com.team4.share_books.login.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.team4.share_books.R;
import com.team4.share_books.entities.QQEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class LoginActivity extends AppCompatActivity {
    private EditText telphoneEv;
    private EditText passwordEv;
    private TextView pwdErrorTx;
    private Button loginBtn;
    private Button registerBtn;
    private TextView missPwdTx;
    private ImageView qqImg;
    private ImageView back;
    private Tencent mTencent;
    private final String APP_ID = "1106161506";
    private IUiListener listener;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        initView();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listener = new BaseUiListener();
        qqImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTencent.logout(mContext);
                Log.d("TAG","do qq logout");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode,resultCode,data,listener);
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void initView() {
        telphoneEv = (EditText) findViewById(R.id.telphoneEv);
        passwordEv = (EditText) findViewById(R.id.passwordEv);
        pwdErrorTx = (TextView) findViewById(R.id.pwdErrorTx);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        missPwdTx = (TextView) findViewById(R.id.missPwdTx);
        qqImg = (ImageView) findViewById(R.id.qqImg);
        back = (ImageView) findViewById(R.id.back);

    }

    public void login() {
        mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        if (!mTencent.isSessionValid()) {
            mTencent.login(this, "all", listener);
            Log.d("TAG","in" + mTencent.getAccessToken());
        }
    }


//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_login;
//    }
private class BaseUiListener implements IUiListener {

    @Override
    public void onComplete(Object o) {
        JSON json = (JSONObject) o;
        Log.d("TAG",json.toJSONString());
        QQEntity qqinfo = json.toJavaObject(QQEntity.class);
        Log.d("TAG",qqinfo.toString());

    }

    @Override
    public void onError(UiError uiError) {
        Log.d("TAG","do onError");

    }

    @Override
    public void onCancel() {
        Log.d("TAG","do cancel");

    }
}
}


