package com.gang.mars.basic.threadpool.demo3;

import java.util.concurrent.*;

/**
 * @author gang.chen
 * @description 工作中三个线程池都不用，
 * 阿里要求：线程资源必须通过线程池提供，不允许在应用中自行显式创建线程
 * 理由1 -> (newFixedThreadPool/newSingleThreadExecutor)new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()));
 *    1 -> LinkedBlockingQueue 无界阻塞队列，最大长度为， Integer.MAX_VALUE 导致OOM
 * 理由2 -> (newCachedThreadPool/ScheduledThreadPool) new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>())
 *    2 -> 创建线程数最大数为，Integer.MAX_VALUE 导致OOM
 * @time 2021/2/2 17:40
 */
public class ThreadPoolInstance {
    public static void main(String[] args) {
        //查看计算机CUP的数量
        System.out.println(Runtime.getRuntime().availableProcessors());

        /*
         * 问题 生产环境maximumPoolSize设置多少，依据是什么？最佳配置方案是？
         * 场景一：CUP密集型（注：任务需要大量的运算，没有阻塞，CUP一直全速运行），公式=CUP核数+1个线程
         * 场景二：I-O密集型（1，CUP以读写为主，线程不是一直在执行任务，公式=CUP核数*2；2，公式=CUP核数/(1-阻塞系数)）阻塞系数 in(0.8-0.9 )
         * 线程池拒绝策略
         * -> AbortPolicy, 直接抛出RejectedExecutionException异常阻止系统正常运行
         * -> CallerRunsPolicy，“调用者运行”一种机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些不能执行的任务，回退给调用者执行（例如主线程）
         * -> DiscardOldestPolicy，抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务
         * -> DiscardPolicy，直接丢弃任务，不予任何处理也不抛出异常。如果允许任务丢失，这是一种最好的方案
         * */
        ExecutorService executorService = new ThreadPoolExecutor(2,5,1L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i <10 ; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
