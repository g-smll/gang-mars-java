package com.gang.mars.basic.threadpool;

import java.util.concurrent.*;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/12 13:35
 */
public class GangMarsThreadPoolExecutor extends ThreadPoolExecutor {
    public GangMarsThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    /**
     * @param corePoolSize 核心线程数
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime 线程空闲，最长活跃时间
     * @param unit 时间单位
     * @param workQueue 阻塞队列(线程安全)
     * @param threadFactory
     * */
    public GangMarsThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public GangMarsThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    /**
     * @param corePoolSize 线程池中的常驻核心线程数
     * @param maximumPoolSize 线程池能够容纳同时执行的最大线程数，值大于1
     * @param keepAliveTime 多余空闲线程存活时间，
     *                      1，当前线程池数量超过corePoolSize时
     *                      2，当空闲时间达到keepAliveTime时
     *                      多余空闲线程会被钱销毁，直到只剩下corePoolSize个线程为止
     * @param unit 存活时间单位
     * @param workQueue 任务队列，被提交但尚未被执行的任务
     * @param threadFactory 生产线程池中工作线程工厂，用户创建线程，一般默认即可
     * @param handler 拒绝策略
     * */
    public GangMarsThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }
}
