package com.shop.ningbaoqi.handler;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AsyncTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyAsyncTask().execute("http:www.baidu.com");//执行异步任务
    }

    class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {
        /**
         * 在线程池中执行，用于执行异步任务，可以调用 publishProgress()方法来更新任务的进度，publishProgress方法会调用onProgressUpdate方法；该方法返回结果给onPostExecute作为参数
         *
         * @param strings
         * @return
         */
        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }

        /**
         * UI线程执行  在异步任务执行之前，此方法会被调用，一般做一些准备工作
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * UI线程执行  在异步任务执行之后，此方法会被调用
         *
         * @param bitmap
         */
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
        }

        /**
         * UI线程执行 当后台任务的执行进度发生改变时此方法会被调用
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /**
         * UI线程执行 当异步任务被取消时，该方法会被调用，这时 onPostExecute 方法不会被调用
         */
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
