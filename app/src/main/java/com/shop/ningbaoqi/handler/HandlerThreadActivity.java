package com.shop.ningbaoqi.handler;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HandlerThreadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    HandlerThread的原理
//    @Override
//    public void run() {
//        mTid = Process.myTid();
//        Looper.prepare();
//        synchronized (this) {
//            mLooper = Looper.myLooper();
//            notifyAll();
//        }
//        Process.setThreadPriority(mPriority);
//        onLooperPrepared();
//        Looper.loop();
//        mTid = -1;
//    }
}
