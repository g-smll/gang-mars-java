package com.gang.mars.basic.gc;

/**
 * @author gang.chen
 * @description JVM垃圾回收，可做为GC Root的对象是
 * 1，虚拟机栈中引用的对象
 * 2，方法区中的类静态属性引用的对象
 * 3，方法区中常量引用的对象
 * 4，本地方法栈中JDI引用的的对象
 * 垃圾-> 内存中已经不再被使用的空间
 * @time 2021/2/20 13:34
 */
public class GcRootInstance1 {

    //方法区中的类静态属性引用的对象
    private static GcRootInstance0 gcRootInstance0;

    //方法区中常量引用的对象
    private static final GcRootInstance0 getGcRootInstance0_ = new GcRootInstance0();
}
