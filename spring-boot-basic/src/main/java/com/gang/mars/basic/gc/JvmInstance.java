package com.gang.mars.basic.gc;

/**
 * @author gang.chen
 * @description 盘点JVM默认配置&调优
 * java程序在运行中
 * 问题1，如何查看JVM某个参数是否开启？
 * 回答：
 * -1.1 查看JDK工具类 C:\Program Files\AdoptOpenJDK\jdk-8.0.272.10-hotspot\bin\jps.exe
 *  -1.1.1 jps -l (注：查看java程序运行进程ID-22164)
 * -1.2 查看JDK工具类 C:\Program Files\AdoptOpenJDK\jdk-8.0.272.10-hotspot\bin\jinfo.exe
 *  -1.2.1 jinfo -flag PrintGCDetails 22164
 * 问题2，具体值是多少？
 * @time 2021/2/20 13:41
 */
public class JvmInstance {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello GC");

        Thread.sleep(Integer.MAX_VALUE);

        System.out.println("Hello GC OUT");
    }
}
