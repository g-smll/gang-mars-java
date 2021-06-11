package com.gang.mars.basic.functionalInterface;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/10 9:11
 */
public class T1 {
    public static void main(String[] args) {
        //(str1, str2) -> "hello! " + str1 + str2; 这是一个函数表达式
        T2 t2 = (str1, str2) -> "hello! " + str1 + str2;
        String s = t2.create("chen", "gang");
        System.out.println(s);

        T3 t3 = ()->"Hello World";
        String s3 = t3.print();
        System.out.println(s3);

        T5 t5 = (str)-> "hello !"+str;
        T5 t50 = T5.DEFAULT;
        String obj = t50.getObj("Hello How Are You!");
        System.out.println(obj);
        String gangC = t5.getObj("GangC");
        System.out.println(gangC);
    }
}

@FunctionalInterface
interface T2 {
    String create(String v1,String v2);
}

@FunctionalInterface
interface T3{
    String print();
}

@FunctionalInterface
interface T4{
    void done();
}

@FunctionalInterface
interface T5{
    T5 DEFAULT = (str)-> "hello !"+str;

    String getObj(String v1);
}

