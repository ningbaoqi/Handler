package com.shop.ningbaoqi.handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "NBQ";
    private ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threadLocal.set(true);
        Log.d(TAG, "" + threadLocal.get());//返回true

        new Thread("thread1") {
            @Override
            public void run() {
                threadLocal.set(false);
                Log.d(TAG, "" + threadLocal.get());//返回false
            }
        }.start();

        new Thread("thread2") {
            @Override
            public void run() {
                Log.d(TAG, "" + threadLocal.get());//返回null
            }
        }.start();
    }
//    ThreadLocal的set方法

//    public void set(T value) {
//        Thread t = Thread.currentThread();
//        ThreadLocalMap map = getMap(t);
//        if (map != null)
//            map.set(this, value);
//        else
//            createMap(t, value);
//    }


//    ThreadLocal的get方法

//    public T get() {
//        Thread t = Thread.currentThread();
//        ThreadLocalMap map = getMap(t);
//        if (map != null) {
//            ThreadLocalMap.Entry e = map.getEntry(this);
//            if (e != null) {
//                @SuppressWarnings("unchecked")
//                T result = (T) e.value;
//                return result;
//            }
//        }
//        return setInitialValue();
//    }
}
