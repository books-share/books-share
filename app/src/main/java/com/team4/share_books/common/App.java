package com.team4.share_books.common;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by john on 17/11/6.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) || "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
//            RongIM.init(this);
//        }
        Log.d("onSuccess","init success");



    }

    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcessInfo : activityManager.getRunningAppProcesses()) {
            if (appProcessInfo.pid == pid ) {
                return  appProcessInfo.processName;
            }
        }
        return  null;
    }
}
