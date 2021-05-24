package com.gang.mars.basic.gc;

/**
 * @author gang.chen
 * @description -Xms/-Xmx
 * @time 2021/2/22 12:50
 */
public class JvmInstance2 {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        //-Xms 内存的64/1
        System.out.println("TOTAL_MEMORY(-Xms)"+totalMemory+"字节"+(totalMemory/(double)1024/1024)+"MB");


        //-Xmx 内存的4/1
        System.out.println("TOTAL_MEMORY(-Xmx)"+maxMemory+"字节"+(maxMemory/(double)1024/1024)+"MB");
    }
}
