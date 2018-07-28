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
|FixedThreadPool|通过Executors.newFixedThreadPool()方法创建， 它是一种线程数量固定的线程池，当线程处于空闲状态时，他们并不会被回收，除非线程池被关闭了，当所有的线程都处于活动状态时，新任务就会处于等待状态，直到由线程空闲出来，由于FixedThreadPool只有核心线程并且这些核心线程不会被回收，这意味着它能够更加快速的响应外界的请求|
|CachedThreadPool|通过Executors.newCachedThreadPool()方法来创建，它是一种线程数量不定的线程池，它只有非核心线程，并且其最大线程数为Integer.MAX_VALUE，相当于最大线程数可以任意大，当线程池中的线程都处于活跃状态时，线程池会创建新的线程来处理新任务，否则就会利用空闲的线程来处理新任务，线程池中的空闲线程都有超时控制，这个超时时长为60s，超过60s闲置线程就会被回收，CachedThreadPool的任务队列其实相当于一个空集合，这将导致任何任务都会立即运行，因为在这种情况下SynchronousQueue是无法插入任务的，SynchronousQueue是一个非常特殊的队列，在很多情况下可以把它理解为一个无法存储元素的队列，CachedThreadPool比较适合执行大量的耗时较少的任务，当整个线程池都处于闲置状态时，线程池中的线程都会超时而被停止，这个时候CachedThreadPool中实际上是没有任何线程的，它几乎是不占用任何系统资源的|
|ScheduledThreadPool|通过Executors.newScheduledThreadPool()方法来创建，它的核心线程数量是固定的，而非核心线程数是没有限制的，并且当非核心线程闲置时会被立即回收，ScheduledThreadPool这类线程池主要用于执行定时任务和具有固定周期的重复任务|
|SingleThreadExecutor|通过Executors.newSingleThreadExecutor()方法创建，这类线程池内部只有一个核心线程，它确保所有的任务都在同一个线程中按顺序执行，SingleThreadExecutor的意义在于统一所有的外界任务到一个线程中，这使得在这些任务之间不需要处理线程同步的问题|

##### FixedThreadPool

```
public static ExecutorService newFixedThreadPool(int var0) {
        return new ThreadPoolExecutor(var0, var0, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
}
```

##### CachedThreadPool

```
public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue());
}
```

##### ScheduledThreadPool

```
public static ScheduledExecutorService newScheduledThreadPool(int var0) {
        return new ScheduledThreadPoolExecutor(var0);
}

public ScheduledThreadPoolExecutor(int var1) {
        super(var1, 2147483647, 0L, TimeUnit.NANOSECONDS, new ScheduledThreadPoolExecutor.DelayedWorkQueue());
}
```

##### SingleThreadExecutor

```
public static ExecutorService newSingleThreadExecutor() {
        return new Executors.FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
}
```
