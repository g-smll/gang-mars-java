package com.gang.mars.basic.threadpool.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gang.chen
 * @description 获取线程方式四，线程池
 * 1->Executors.newFixedThreadPool() 一池固定数线程
 * 2->Executors.newSingleThreadExecutor() 一池一线程
 * 3->Executors.newCachedThreadPool() 一池多线程
 * @time 2021/1/29 13:42
 */
public class ThreadPoolInstance {
    public static void main(String[] args) {
        NThreadInPoolHandle();
    }

    //线程池使用动态线程数，处理业务
    private static void NThreadInPoolHandle() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            //处理10个业务
            for (int i = 0; i < 10; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 业务处理");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

    //线程池使用一个线程，处理业务
    private static void oneThreadPoolHandle() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try{
            // 处理10个业务
            for (int i = 0; i < 10; i++) {
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

    //线程池使用5个线程，处理业务
    private static void fixedThreadPools() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try{
            //模拟10个用户
            for (int i = 0; i < 10; i++) {
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
