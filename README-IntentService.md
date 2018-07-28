### IntentService
+ 服务中的代码都是`默认运行在主线程`当中的，需要注意；`IntentService`是`Service的子类`,优先级比`Service`高，可以用其处理高优先级的任务，因此它不是普通的Service，它比普通的Service增加了额外的功能；`IntentService`是继承并处理`异步请求`的一个类，在`IntentService`内有一个`工作线程`来处理耗时操作，启动`IntentService`的方式和启动传统`Service`一样，同时，当任务执行完后，`IntentService`会`自动停止`，而不需要手动去控制或stopSelf()，IntentService封装了HandlerThread和Handler；另外，可以启动`IntentService`多次，而每一个`耗时操作`会以`工作队列`的方式在`IntentService`的`onHandleIntent`回调方法中执行，并且，每次只会执行`一个工作线程`，执行完第一个再执行第二个；

|Service本身存在的两个问题|
|------|
|Service不会专门启动一个单独的进程，Service与它所在的应用位于同一个进程中|
|Service不是一条新的线程，因此不应该在Service中直接处理耗时的任务|

+ 如果开发者需要在Service中处理耗时任务，建议在Service中另外启动一条新线程来处理该耗时任务；而`IntentService`正好可以弥补`Service`的上述两个不足：`IntentService将会使用队列来管理请求Intent`，每当客户端代码通过`Intent请求启动IntentService`时，`IntentService`会将该`Intent加入队列`中，然后`开启一条新的worker线程`来处理该Intent。对于`异步`的startService()请求，`IntentService`会依次序依次处理队列中的Intent，该`线程`保证`同一时刻只处理一个Intent`，由于IntentService使用新的worker线程处理Intent请求，因此`IntentService不会阻塞主线程`，所以`IntentService自己就可以处理耗时任务`；

|IntentService具有如下特征|
|------|
|`IntentService会创建单独的worker线程`来处理所有的Intent请求|
|`IntentService会创建单独的worker线程来处理onHandleIntent()`方法实现的代码，因此开发者无须处理多线程问题|
|所有请求处理完成后，IntentService会自动停止，因此开发者无须调用stopSelf()方法来停止该Service|
|为Service的onBind()方法提供了默认实现，默认实现的onBind()方法返回null|
|为Service的onStartCommand()方法提供了默认实现，该实现会将请求Intent添加到队列中|

+ 从上面的介绍可以看出，扩展IntentService实现Service无须重写onBind()、onStartCommand()方法，只要`重写onHandleIntent()`方法即可；

#### IntentService用法
[IntentService用法](https://github.com/ningbaoqi/Handler/blob/master/README-IntentService.md)
