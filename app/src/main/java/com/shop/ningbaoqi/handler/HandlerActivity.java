package com.shop.ningbaoqi.handler;

import android.os.Bundle;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class HandlerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    Handler最终发送消息的函数;向消息队列中插入消息

//    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
//        MessageQueue queue = mQueue;
//        if (queue == null) {
//            RuntimeException e = new RuntimeException(
//                    this + " sendMessageAtTime() called with no mQueue");
//            Log.w("Looper", e.getMessage(), e);
//            return false;
//        }
//        return enqueueMessage(queue, msg, uptimeMillis);
//    }

//    private boolean enqueueMessage(MessageQueue queue, Message msg, long uptimeMillis) {
//        msg.target = this;
//        if (mAsynchronous) {
//            msg.setAsynchronous(true);
//        }
//        return queue.enqueueMessage(msg, uptimeMillis);
//    }


//    Handler进入处理阶段由Looper回调的方法

//    public void dispatchMessage(Message msg) {
//        if (msg.callback != null) {//先处理callback
//            handleCallback(msg);
//        } else {
//            if (mCallback != null) {//次mCallback
//                if (mCallback.handleMessage(msg)) {
//                    return;
//                }
//            }
//            handleMessage(msg);//最后都没有才会调用该方法
//        }
//    }
}
