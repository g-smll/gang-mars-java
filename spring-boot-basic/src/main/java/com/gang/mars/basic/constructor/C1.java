package com.gang.mars.basic.constructor;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 13:40
 */
public class C1 extends C2 {
    public static void main(String[] args) {
        C1 c1 = new C1();
        if (c1 instanceof C3){
            System.out.println(((C3) c1).getC4());
        }
    }
}

class C2 extends C3{
}

class C3 {
    private final C4 c4;

    public C3(){
        c4 = new C4();
        System.out.println("C3 running....");
    }

    public C4 getC4() {
        return this.c4;
    }
}

class C4 {

}