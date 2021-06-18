package com.gang.mars.basic.clazz;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/18 13:07
 */
public class C1 {
    public static void main(String[] args) {
        try {
            Class<?> c2 = Class.forName(C2.class.getName());
            System.out.println(c2);

            Class<?> c3 = C1.class.getClassLoader().loadClass("com.gang.mars.basic.clazz.C3");
            System.out.println(c3);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class C2{}

class C3{}

class C4{}
