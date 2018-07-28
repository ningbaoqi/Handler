### Android中的线程池

|线程池的优点|
|------|
|重用线程池中的线程，避免因为线程的创建和销毁所带来的性能开销|
|能有效控制线程池的最大并发数，避免大量的线程之间因抢占系统资源而导致阻塞现象|
|能够对线程进行简单的管理，并提供定时执行以及指定间隔循环执行等功能|

#### 线程池的参数说明
[线程池的参数说明](https://github.com/ningbaoqi/Handler/commit/7a2bf3cee7a6c6896b2c87551196a7aea9209419)

|线程池执行任务时遵循的规则|
|------|
|如果线程池中的线程数量未达到核心线程的数量，那么会直接启动一个核心线程来执行任务|
|如果线程池中的线程数量已经达到或者超过核心线程的数量，那么任务会被插入到任务队列中排队等待执行|
|如果在步骤2中无法将任务插入到任务队列中，这往往是由于任务队列已满，这个时候如果线程数量未达到线程池规定的最大值，那么会立刻启动一个非核心线程来执行任务|
|如果步骤3中线程数量已经达到线程池规定的最大值，那么就拒绝执行此任务，线程池会调用RejectedExecutionHandler的rejectedExecution方法来通知调用者|

#### 线程池的分类

|线程池的分类|说明|
|------|-------|
|FixedThreadPool|通过Executors.newFixedThreadPool()方法创建， 它是一种线程数量固定的线程池，当线程处于空闲状态时，他们并不会被回收l，除非线程池被关闭了，当所有的线程都处于活动状态时，新任务就会处于等待状态，直到由线程空闲出来，由于FixedThreadPool只有核心线程并且这些核心线程不会被回收，这意味着它能够更加快速的响应外界的请求|

##### FixedThreadPool

```
public static ExecutorService newFixedThreadPool(int var0) {
        return new ThreadPoolExecutor(var0, var0, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
}
```
