package com.shop.ningbaoqi.handler;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IntentServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 直接崩溃
     *
     * @param view
     */
    public void signal(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    /**
     * 正常运行
     *
     * @param view
     */
    public void intentService(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
}
