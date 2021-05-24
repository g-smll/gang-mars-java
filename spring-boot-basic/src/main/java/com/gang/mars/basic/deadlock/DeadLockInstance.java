package com.gang.mars.basic.deadlock;

/**
 * @author gang.chen
 * @description 死锁实例与排查
 * @time 2021/2/18 10:54
 */
public class DeadLockInstance {
    public static void main(String[] args) {
        /*
        * 1:JDK工具类 jps.exe(注：在JAVA的bin目录下)
        *
        * linux   ps -ef|grep XXX    ls -l
        * window  jps                jps -l(注：查看线程)
        *
        * 2:JDK工具类 jstack.exe()
        * jstack 9752(注：线程编号)
        * */

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new Thread1HoldLock(lockA,lockB),"ThreadA").start();
        new Thread(new Thread1HoldLock(lockB,lockA),"ThreadB").start();
    }
}
