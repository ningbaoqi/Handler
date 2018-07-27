### AsyncTask
+ `AsyncTask`本质是一个封装了`线程池`和`handler`的`异步框架`；`AsyncTask`只能做一些耗时比较`短`的操作，如果想做`耗时比较长的操作`，需要使用`线程池`来做；`AsyncTask<Params , Progess , Result>`是一个抽象类；

|继承`AsyncTask`时需要指定如下三个泛型参数|说明|
|------|------|
|Params|启动任务执行的输入参数的类型|
|Progress|后台任务完成的进度值的类型|
|Result|后台执行任务完成后返回结果的类型|

+ 使用AsyncTask必须遵守如下规则：

|规则|
|------|
|必须在UI线程中创建AsyncTask的实例|
|必须在UI线程中调用AsyncTask的execute方法|
|AsyncTask的onPostExecute、OnpreExecute、doInBackground、onProgressUpdate方法，不应该由程序员代码调用，而是由Android系统负责调用|
|每个AsyncTask只能被执行一次，即只能调用一次execute方法；多次调用将会引发异常,但是在多次创建AsyncTask子类对象的时候，因为AsyncTask内部是一个线程池的结构，所以需要等待原来的AsyncTask执行完成之后，才能执行刚启动的AsyncTask|
#### AsyncTask的详细说明
[AsyncTask的详细说明](https://github.com/ningbaoqi/Handler/commit/02c908c81d92b220359543b8fa4962855bba5aa8)
#### AsyncTask的机制原理
+ `AsyncTask`的本质是一个`静态的线程池`，`AsyncTask`派生出的子类可以实现不同的`异步任务`，这些异步任务都是提交到静态的线程池中执行；线程池中的`工作线程`执行`doInBackground(mParam)`方法执行异步任务，当任务状态改变之后，`工作线程`会向`UI线程`发送消息，`AsyncTask`内部的`InternalHandler`响应这些消息，并调用相关的回调方法；
#### AsyncTask的注意事项

|AsyncTask的注意事项|说明|
|------|------|
|内存泄漏|因为AsyncTask会被声明为非静态内部类，所以创建的对象会持有Activity的引用，如果Activity被销毁了，由于AsyncTask一些后台线程还在执行，所以说想销毁Activity时，该Activity无法被内存回收，就引起了内存泄露；解决方法：将AsyncTask声明为静态的或者让AsyncTask持有相关的Activity的弱引用，还可以在Activity的onDestroy方法中进行AsyncTask的cancel()方法调用|
|生命周期|如果Activity销毁之前没有取消AsyncTask，可能导致AsyncTask在Activity销毁之前导致崩溃|
|结果丢失|由于屏幕旋转或者Activity被系统杀掉，但是AsyncTask持有的引用时之前的Activity，但是这个Activity已经无效了，所以在AsyncTask中调用界面UI的时候将不会生效|
|并行或串行|Android1.6之前的版本，AsyncTask使用串行，也就是AsyncTask把所有的任务都一串一串的放在线程池中，有序的进行执行，在Android1.6到Android2.3版本，AsyncTask使用并行，但是为了保持系统稳定，Android2.3以后又改成了串行，但是还是可以实现并行，想执行并行的时候可以调用excuteOnExcute()方法即可，但是建议使用串行，这样能保持线程池的稳定|
