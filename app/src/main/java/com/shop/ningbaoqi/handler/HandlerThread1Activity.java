package com.shop.ningbaoqi.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HandlerThread1Activity extends AppCompatActivity {
    private HandlerThread handlerThread;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handlerThread = new HandlerThread("handler-thread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper()) {//将handler与HandlerThread的Looper进行绑定，执行消息的时候在HandlerThread线程中执行
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //运行在handler-thread线程中，可以执行耗时操作
            }
        };
        handler.sendEmptyMessage(1);//在主线程发送消息

        new Thread(new Runnable() {//在子线程发送消息
            @Override
            public void run() {
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();//释放资源
    }
}
