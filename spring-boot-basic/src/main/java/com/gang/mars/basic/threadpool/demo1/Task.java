package com.gang.mars.basic.threadpool.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/12 13:57
 */
public class Task implements Runnable{

    private final int nov;

    public Task(int nov) {
        this.nov = nov;
    }


    @Override
    public void run() {
        System.out.println("执行当前任务线程名称->" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是任务->" +nov +" 执行...");
    }
}
