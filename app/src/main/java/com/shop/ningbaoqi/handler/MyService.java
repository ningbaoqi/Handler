package com.shop.ningbaoqi.handler;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        long endTime = System.currentTimeMillis() + 20* 1000;
        while (System.currentTimeMillis() < endTime){
            try {
                wait(endTime - System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("nbq" , "耗时完成");
        return START_STICKY;
    }
}

