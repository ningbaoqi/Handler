### HandlerThread
+ 开启`子线程`进行耗时操作，但是`多次创建`和`销毁线程`是很`消耗系统资源`的；为了解决这个问题Google封装好了框架`HandlerThread`框架，`HandlerThread`的本质是`Handler` + `Thread` + `Looper`它内部有一个`Looper`，自己创建的子线程默认是没有`Looper`的，`HandlerThread`的本质是一个`线程类`，它继承了`Thread`，`HandlerThread`有自己的内部的`Looper`对象，可以进行`looper`循环；通过获取`HandlerThread`的`looper`对象传递给`Handler`对象，可以在`handleMessage`方法中执行`异步任务`；优点是：不会干扰或`阻塞`UI线程，减少了对性能的消耗；缺点是：不能同时进行多任务的处理，需要等待进行处理，处理效率较低；与线程池并发不同，`HandlerThread`是一个串行队列，`HandlerThread`背后只有一个线程；[HandlerThread的原理](https://github.com/ningbaoqi/Handler/commit/ef07d171826539cb352dec2fd1a8690cc550b673)；由于HandlerThread的run方法是一个无限循环，因此当明确不需要再使用HandlerThread时，可以通过它的quit和quitSafely方法来终止线程的执行；
#### HandlerThread用法
[HandlerThread用法](https://github.com/ningbaoqi/Handler/commit/1a336e327748317b06b843666bcf882f69c27ace)
