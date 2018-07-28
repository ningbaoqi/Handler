package com.shop.ningbaoqi.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

/**
 * corePoolSize  线程池的核心线程数，默认情况下，核心线程会在线程池中一直存活，即使他们处于闲置状态，如果将ThreadPoolExecutor的allowCoreThreadTimeOut属性设置为true，那么限制的核心线程在等待新任务到来时会又超时策略，这个时间间隔由keepAliveTime所指定，当等待时间超时keepAliveTime所指定的时长后，核心线程就会被终止
 * maximumPoolSize  线程池所能容纳的最大线程数，当活动线程数达到这个数值后，后续的新任务将会被阻塞
 * keepAliveTime  非核心线程闲置时的超时时长，超过这个时长，非核心线程就会被回收，当ThreadPoolExecutor的allowCoreThreadTimeOut属性设置为true时，keepAliveTime同样会作用于核心线程
 * unit  用于指定keepAliveTime参数的时间单位
 * workQueue  线程池中的任务队列，通过线程池的execute方法提交的Runnable对象会存储在这个参数中
 * threadFactory 线程工厂，为线程池提供创建新线程的功能，threadFactory是一个接口，它只有一个方法Thread newThread(Runnable r)
 *
 * 不常用的参数：RejectedExecutionHandler handler 当线程池无法执行新任务时，这可能是由于任务队列已满或者是无法成功执行任务，这个时候ThreadPoolExecutor会调用handler的rejectedExecution方法来通知调用者
 */
//    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) ;
}