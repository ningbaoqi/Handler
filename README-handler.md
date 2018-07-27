### Handler
+ Handler是通过发送和处理`Message`和`Runnable`对象来关联相对应线程的`MessageQueue`，MessageQueue是采用单链表的数据结构来存储消息队列的，可以让对应的`Message`和`Runnable`在未来的某个时间点进行相应处理，让自己想要处理的耗时操作放在`子线程`，让`更新UI`的操作放在`主线程`；[Handler的工作原理](https://github.com/ningbaoqi/Handler/commit/459794e5e84829c9454ff59d755e20df28edd91b)
### ThreadLocal
+ ThreadLocal并不是线程，它的作用是可以在每个线程中存储数据，Handler内部获取到当前线程的Looper就是使用了ThreadLocal，ThreadLocal可以在不同的线程中互不干扰的存储并提供数据，通过ThreadLocal可以轻松获取每个线程的Looper；ThreadLocal是一个线程内部的数据存储类，通过它可以在指定的线程中存储数据，数据存储以后，只有在指定线程中可以获取到存储的数据，对于其他线程来说则无法获取到数据；
[ThreadLocal的工作原理](https://github.com/ningbaoqi/Handler/commit/5cadf4cddb26e081a02b16caecfc251b0f523d6e)
### MessageQueue的工作原理
[MessageQueue的工作原理](https://github.com/ningbaoqi/Handler/commit/9419efcce9b2cfc63748b4b38bf6e17c2b9f6356)
### Looper的工作原理
[Looper的工作原理](https://github.com/ningbaoqi/Handler/commit/8810af5244fac2f794bfa78277d2dcc3b73a9fc1)
##### Handler引起的内存泄露以及解决办法
+ 当Activity中的`成员变量Handler不是static`的时候，当该Activity要回收的时候，由于Handler对象有可能在做一些耗时操作，导致Handler对象没有被释放，所以该Activity对象也不会被释放，这样就导致了Activity没有被回收，停留在堆内存当中，就造成了`内存泄露`；解决这个问题的方法是将Handler对象设置成为`static`，在Activity的`onDestroy()`方法中调用`handler的removeCallbacks()方法`；
##### 自定义一个线程相关的Handler
+ 自己启动的子线程，必须创建一个`Looper对象`，`并启动它`，创建Looper对象调用它的`prepare()`方法即可，`prepare`方法保证每个线程最多只有一个Looper对象，接下来调用`Looper`的静态`loop()`方法来启动它；

```
public class TestActivity extends AppCompatActivity {
    private MyThread thread;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("nbq----main" , Thread.currentThread().getId() + "");
        thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        thread.handler.sendEmptyMessage(1);
    }    
    class MyThread extends Thread {
        public Handler handler;
        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    Log.d("nbq-------" , Thread.currentThread().getId() + "");
                }
            };
            Looper.loop();
        }
    }
}
```
