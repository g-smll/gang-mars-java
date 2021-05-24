package com.gang.mars.basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gang.chen
 * @description JAVA 线程开发 生产与消费
 * 虚假唤醒：if判断 -> while判断 代替
 * @time 2021/1/13 8:48
 */
public class ShareData {
    private int num = 0;
    private final Lock lock =new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void wrongIncrement() throws InterruptedException {
        lock.lock();
        try {
            if (num != 0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void wrongDecrement() throws InterruptedException {
        lock.lock();
        try {
            if (num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }



    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
