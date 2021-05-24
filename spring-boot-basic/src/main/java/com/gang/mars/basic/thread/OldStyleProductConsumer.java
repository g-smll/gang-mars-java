package com.gang.mars.basic.thread;

/**
 * @author gang.chen
 * @description 线程开发要求,一个初始值为零变更，两个线程交替操作，一线程+1,一线程-1，进行5轮
 * 知识点：虚假唤醒
 * @time 2021/1/13 8:46
 */
public class OldStyleProductConsumer {
    public static void main(String[] args) {
        //CASE1();
        CASE2();

    }

    private static void CASE2() {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.wrongIncrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.wrongDecrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.wrongIncrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.wrongDecrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"EE").start();


        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.wrongIncrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();


        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.wrongDecrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"FF").start();
    }

    private static void CASE1() {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
