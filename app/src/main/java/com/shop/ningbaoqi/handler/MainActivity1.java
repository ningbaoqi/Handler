package com.shop.ningbaoqi.handler;

import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.Trace;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LogPrinter;

import java.io.File;

public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    主线程UI线程的消息机制启动过程；ActivityThread的main方法中调用
    
//    public static void main(String[] args) {
//        Trace.traceBegin(Trace.TRACE_TAG_ACTIVITY_MANAGER, "ActivityThreadMain");
//
//        // CloseGuard defaults to true and can be quite spammy.  We
//        // disable it here, but selectively enable it later (via
//        // StrictMode) on debug builds, but using DropBox, not logs.
//        CloseGuard.setEnabled(false);
//
//        Environment.initForCurrentUser();
//
//        // Set the reporter for event logging in libcore
//        EventLogger.setReporter(new EventLoggingReporter());
//
//        // Make sure TrustedCertificateStore looks in the right place for CA certificates
//        final File configDir = Environment.getUserConfigDirectory(UserHandle.myUserId());
//        TrustedCertificateStore.setDefaultUserDirectory(configDir);
//
//        Process.setArgV0("<pre-initialized>");
//
//        Looper.prepareMainLooper();
//
//        ActivityThread thread = new ActivityThread();
//        thread.attach(false);
//
//        if (sMainThreadHandler == null) {
//            sMainThreadHandler = thread.getHandler();
//        }
//
//        if (false) {
//            Looper.myLooper().setMessageLogging(new
//                    LogPrinter(Log.DEBUG, "ActivityThread"));
//        }
//
//        // End of event ActivityThreadMain.
//        Trace.traceEnd(Trace.TRACE_TAG_ACTIVITY_MANAGER);
//        Looper.loop();
//
//        throw new RuntimeException("Main thread loop unexpectedly exited");
//    }
}
