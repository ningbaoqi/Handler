### Handler
+ Handler是通过发送和处理`Message`和`Runnable`对象来关联相对应线程的`MessageQueue`，可以让对应的`Message`和`Runnable`在未来的某个时间点进行相应处理，让自己想要处理的耗时操作放在`子线程`，让`更新UI`的操作放在`主线程`；
