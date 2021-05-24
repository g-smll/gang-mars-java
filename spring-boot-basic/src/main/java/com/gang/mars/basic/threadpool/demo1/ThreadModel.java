package com.gang.mars.basic.threadpool.demo1;


import com.gang.mars.basic.threadpool.GangMarsThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/12 13:16
 */
public class ThreadModel {
    public static void main(String[] args) {

        final ThreadPoolExecutor poolExecutor = new GangMarsThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());
        for (int i = 0; i < 9; i++) {
            poolExecutor.execute(new Task(i));
        }
        poolExecutor.shutdown();
    }
}
