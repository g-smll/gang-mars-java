package com.gang.mars.basic.functionalInterface;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/11 19:23
 */
public class Y1 {
    public static void main(String[] args) {
        Y2 y2 = (str) -> "Hello"+str;
        String s = y2.sayHello("Gang.Chen");
    }
}

@FunctionalInterface
interface Y2 {
   String sayHello(String str);
}

