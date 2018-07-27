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
### AsyncTask的详细说明
[AsyncTask的详细说明](https://github.com/ningbaoqi/Handler/commit/02c908c81d92b220359543b8fa4962855bba5aa8)
