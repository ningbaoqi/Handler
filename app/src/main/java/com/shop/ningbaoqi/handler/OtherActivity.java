package com.shop.ningbaoqi.handler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    //updateUI();
                    viewUI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void updateUI() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("shuaige");
            }
        });
    }

    public void viewUI() {
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("cool man");
            }
        });
    }
}
