package com.shop.ningbaoqi.handler;

import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.os.Trace;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Printer;

/**
 * Looper的工作原理：Looper会不停的从MessageQueue中查看是否有新消息，如果有新消息就会立刻处理，否则就一直阻塞在那里
 */
public class LooperActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    Looper的构造方法

//    private Looper(boolean quitAllowed) {
//        mQueue = new MessageQueue(quitAllowed);创建消息队列
//        mThread = Thread.currentThread();保存当前线程
//    }


//    为当前线程创建Looper

//    private static void prepare(boolean quitAllowed) {
//        if (sThreadLocal.get() != null) {
//            throw new RuntimeException("Only one Looper may be created per thread");
//        }
//        sThreadLocal.set(new Looper(quitAllowed));
//    }


//    开启消息循环

//    public static void loop() {
//        final Looper me = myLooper();
//        if (me == null) {
//            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
//        }
//        final MessageQueue queue = me.mQueue;
//
//        // Make sure the identity of this thread is that of the local process,
//        // and keep track of what that identity token actually is.
//        Binder.clearCallingIdentity();
//        final long ident = Binder.clearCallingIdentity();
//
//        for (;;) {
//            Message msg = queue.next(); // might block
//            if (msg == null) {
//                // No message indicates that the message queue is quitting.
//                return;
//            }
//
//            // This must be in a local variable, in case a UI event sets the logger
//            final Printer logging = me.mLogging;
//            if (logging != null) {
//                logging.println(">>>>> Dispatching to " + msg.target + " " +
//                        msg.callback + ": " + msg.what);
//            }
//
//            final long slowDispatchThresholdMs = me.mSlowDispatchThresholdMs;
//
//            final long traceTag = me.mTraceTag;
//            if (traceTag != 0 && Trace.isTagEnabled(traceTag)) {
//                Trace.traceBegin(traceTag, msg.target.getTraceName(msg));
//            }
//            final long start = (slowDispatchThresholdMs == 0) ? 0 : SystemClock.uptimeMillis();
//            final long end;
//            try {
//                msg.target.dispatchMessage(msg);
//                end = (slowDispatchThresholdMs == 0) ? 0 : SystemClock.uptimeMillis();
//            } finally {
//                if (traceTag != 0) {
//                    Trace.traceEnd(traceTag);
//                }
//            }
//            if (slowDispatchThresholdMs > 0) {
//                final long time = end - start;
//                if (time > slowDispatchThresholdMs) {
//                    Slog.w(TAG, "Dispatch took " + time + "ms on "
//                            + Thread.currentThread().getName() + ", h=" +
//                            msg.target + " cb=" + msg.callback + " msg=" + msg.what);
//                }
//            }
//
//            if (logging != null) {
//                logging.println("<<<<< Finished to " + msg.target + " " + msg.callback);
//            }
//
//            // Make sure that during the course of dispatching the
//            // identity of the thread wasn't corrupted.
//            final long newIdent = Binder.clearCallingIdentity();
//            if (ident != newIdent) {
//                Log.wtf(TAG, "Thread identity changed from 0x"
//                        + Long.toHexString(ident) + " to 0x"
//                        + Long.toHexString(newIdent) + " while dispatching to "
//                        + msg.target.getClass().getName() + " "
//                        + msg.callback + " what=" + msg.what);
//            }
//
//            msg.recycleUnchecked();
//        }
//    }

//    退出Looper：可以使用quit方法和quitSafely方法；quit方法直接退出Looper，而quitSafely方法只是设定一个退出的标记，然后把消息队列中的已有消息处理完毕后才安全的退出；自己开启的Looper在不需要使用的时候，建议推出
}
