package com.gang.mars.basic.volatiles;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/8 14:10
 */
public class T2 {
    volatile int n = 0;

    public void add(){
        /*
        * GETFIELD com/gang/mars/basic/volatiles/T2.n : I 获取主内存值
        * ICONST_1 到线程内存
        * IADD 加1
        * PUTFIELD com/gang/mars/basic/volatiles/T2.n : I 同步主内值
        */
        //一个N++ 对应的字节码为三个操作
        n++;
    }
}
