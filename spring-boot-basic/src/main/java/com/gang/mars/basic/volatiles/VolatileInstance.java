package com.gang.mars.basic.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @author gang.chen
 * @description 验证volatile可见性
 * 1 验证volatile可见性
 * 1.1 int num = 0; 线程间不可见
 * 1.2 volatile int num = 0; 线程间可见
 *
 * 2 验证volatile非原子性(100人签名，由1签约到100，不能被覆盖)
 * 2.1 why -> 从子节码分析，参考T2
 * 2.2 如何解决原子性问题volatile
 *  - synchronized
 * @time 2021/1/8 9:56
 */
public class VolatileInstance {
    public static void main(String[] args) {
        NonAtomicity();
    }


    /**
     * volatile 非原子性的描述
     * 1， 要求创建20个线，每个线程++ 到1000，预计加到20000，实现小于20000
     * */
    private static void NonAtomicity() {
        T1 t1 = new T1();
        //定义20个线程,每个线程从1加到1000，执行20次，
        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    t1.plus();
                }
            },String.valueOf(i)).start();
        }

        //等待20个线程执行完成
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("预计结果为->20000; 计算结果为->"+t1.num);
    }

    // Volatile 可见性 验证
    private static void VolatileInVisibility() {
        T1 t1 = new T1();
        //子线程
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" come in");
            try {
                TimeUnit.SECONDS.sleep(4);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.add();
            System.out.println(Thread.currentThread().getName()+" update 100");
        },"thread1").start();

        //主线程
        while (t1.num == 0){
            //初始值为0,在此处循环
        }
        //t1.num == 100主线程执行输出，主线程与子线程同时感知到num的变更
        System.out.println(Thread.currentThread().getName()+" value="+t1.num);
    }
}

class T1 {
    // int num = 0; 场景1
    // volatile int num = 0; 场景2
    volatile int num = 0;

    public void add(){
        this.num = 100;
    }

    /**
     * num 前加 volatile
     * public public synchronized void plus() 可以保证
     */
    public void plus(){
        num++;
    }
}