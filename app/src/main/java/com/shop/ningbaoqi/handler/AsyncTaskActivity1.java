package com.shop.ningbaoqi.handler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class AsyncTaskActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    启动AsyncTask任务  sDefaultExecutor是一个串行的线程池，一个进程中所有的AsyncTask全部在这个串行的线程池中排队执行

//    @MainThread
//    public final AsyncTask<Params, Progress, Result> execute(Params... params) {
//        return executeOnExecutor(sDefaultExecutor, params);
//    }
//    @MainThread
//    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor exec, Params... params) {
//        if (mStatus != AsyncTask.Status.PENDING) {
//            switch (mStatus) {
//                case RUNNING:
//                    throw new IllegalStateException("Cannot execute task:"
//                            + " the task is already running.");
//                case FINISHED:
//                    throw new IllegalStateException("Cannot execute task:"
//                            + " the task has already been executed "
//                            + "(a task can be executed only once)");
//            }
//        }
//
//        mStatus = AsyncTask.Status.RUNNING;
//        onPreExecute();
//        mWorker.mParams = params;
//        exec.execute(mFuture);
//        return this;
//    }


//    线程池的执行过程
//    private static class SerialExecutor implements Executor {
//        final ArrayDeque<Runnable> mTasks = new ArrayDeque<Runnable>();
//        Runnable mActive;
//
//        public synchronized void execute(final Runnable r) {
//            mTasks.offer(new Runnable() {
//                public void run() {
//                    try {
//                        r.run();
//                    } finally {
//                        scheduleNext();
//                    }
//                }
//            });
//            if (mActive == null) {
//                scheduleNext();
//            }
//        }
//
//        protected synchronized void scheduleNext() {
//            if ((mActive = mTasks.poll()) != null) {
//                THREAD_POOL_EXECUTOR.execute(mActive);
//            }
//        }
//    }
}
