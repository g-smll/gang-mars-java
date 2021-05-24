package com.gang.mars.basic.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author gang.chen
 * @description 持有锁线程实例一
 * @time 2021/2/18 10:59
 */
public class Thread1HoldLock implements Runnable {

    private String lockA;
    private String lockB;

    public Thread1HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"\t 尝试获得："+lockB);

            try { TimeUnit.SECONDS.sleep(2); }catch (InterruptedException e){ e.printStackTrace(); }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t 尝试获得："+lockA);
            }
        }
    }
}
