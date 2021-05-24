package com.gang.mars.basic.condition;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gang.chen
 * @description 要求线程AA打印5次，BB打印10，CC打印15次，再来一组，来10轮
 * @time 2021/1/19 13:14
 */
public class ShareResource {

    /**
     * A -> 1 A 线程
     * B -> 2 B 线程
     * C -> 3 C 线程
     * */
    private int num = 1;

    //private final int SLEEP_TIME = 3;

    private final Lock lock = new ReentrantLock();

    private final Condition condition1 = lock.newCondition();

    private final Condition condition2 = lock.newCondition();

    private final Condition condition3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while (num != 1){
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t" + i);
            }
            num = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while (num != 2){
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while ( 3 != num){
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            num = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
