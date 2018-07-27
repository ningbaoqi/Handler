### Handler
+ Handler是通过发送和处理`Message`和`Runnable`对象来关联相对应线程的`MessageQueue`，MessageQueue是采用单链表的数据结构来存储消息队列的，可以让对应的`Message`和`Runnable`在未来的某个时间点进行相应处理，让自己想要处理的耗时操作放在`子线程`，让`更新UI`的操作放在`主线程`；ThreadLocal并不是线程，它的作用是可以在每个线程中存储数据，Handler内部获取到当前线程的Looper就是使用了ThreadLocal，ThreadLocal可以在不同的线程中互不干扰的存储并提供数据，通过ThreadLocal可以轻松获取每个线程的Looper；
##### Handler引起的内存泄露以及解决办法
+ 当Activity中的`成员变量Handler不是static`的时候，当该Activity要回收的时候，由于Handler对象有可能在做一些耗时操作，导致Handler对象没有被释放，所以该Activity对象也不会被释放，这样就导致了Activity没有被回收，停留在堆内存当中，就造成了`内存泄露`；解决这个问题的方法是将Handler对象设置成为`static`，在Activity的`onDestroy()`方法中调用`handler的removeCallbacks()方法`；
