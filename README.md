### Handler
[Handler](https://github.com/ningbaoqi/Handler/blob/master/README-handler.md)
### AsyncTask
[AsyncTask](https://github.com/ningbaoqi/Handler/blob/master/README-asynctask.md)
### HandlerThread
[HandlerThread](https://github.com/ningbaoqi/Handler/blob/master/README-handlerthread.md)
### IntentService
[IntentService](https://github.com/ningbaoqi/Handler/blob/master/README-IntentService.md)

### 子线程不能更新UI的其他解决方法

|方案|
|------|
|Activity.runOnUiThread(Runnable)|
|View.post(Runnable)|
|View.postDelayed(Runnable , long)|
