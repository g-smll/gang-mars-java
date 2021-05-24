package com.gang.mars.basic.composite;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author gang.chen
 * @description 综合使用 volatile / CAS / atomicInteger / BlockQueue / 线程交互 / 原子引用
 * @time 2021/1/25 13:12
 */
public class composite {
    public static void main(String[] args)  {
        Resource resource = new Resource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                resource.prod();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                resource.consumer();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒线程结束....");

        resource.stop();
    }
}
