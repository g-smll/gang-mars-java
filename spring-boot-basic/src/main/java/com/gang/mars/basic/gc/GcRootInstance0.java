package com.gang.mars.basic.gc;

/**
 * @author gang.chen
 * @description JVM垃圾回收，可做为GC Root的对象是
 * 1，虚拟机栈中引用的对象
 * 2，方法区中的类静态属性引用的对象
 * 3，方法区中常量引用的对象
 * 4，本地方法栈中JDI引用的的对象
 * 垃圾-> 内存中已经不再被使用的空间
 * @time 2021/2/19 9:56
 */
public class GcRootInstance0 {
    /*
     * 1，M1方法是在虚拟机栈中
     * 2，M1方法引用了GcRootInstance对象
     * 3，GcRootInstance 可视为GC Root对象
     * */
    public static void M1(){
        GcRootInstance0 root = new GcRootInstance0();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        M1();
    }


}
