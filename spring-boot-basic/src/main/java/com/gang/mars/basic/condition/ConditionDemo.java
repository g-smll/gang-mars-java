package com.gang.mars.basic.condition;

/**
 * @author gang.chen
 * @description 要求线程AA打印5次，BB打印10，CC打印15次，再来一组，来10轮
 * @time 2021/1/19 13:13
 */
public class ConditionDemo {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.print5();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.print10();
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.print15();
            }
        },"CC").start();
    }
}
