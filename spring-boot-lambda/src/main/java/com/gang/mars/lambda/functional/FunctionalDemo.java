package com.gang.mars.lambda.functional;

import com.gang.mars.lambda.entities.User;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/5 12:55
 */
public class FunctionalDemo {
    @FunctionalInterface
    interface Calculator{
        public Integer sq(Integer s);
    }

    @FunctionalInterface
    public interface Customizer<T> {
        public void Customizer(T t);

        static <T> Customizer<T> withDefaults1(){
            return t -> {};
        }
    }

    static class FHttpSecurity{
        void csrf(Customizer<User> csrfCustomizer){
            System.out.println(csrfCustomizer);
        }
    }

    public static void main(String[] args) {
        FHttpSecurity fHttpSecurity = new FHttpSecurity();
        fHttpSecurity.csrf(Customizer.withDefaults1());
    }

    /*public static void main(String[] args) {
        //type 1
        Calculator calculator1 = (Integer s) ->{return s*s;};
        System.out.println(calculator1.sq(5));
        //type 2
        Calculator calculator2 =(s) -> {return s+s ;};
        System.out.println(calculator2.sq(5));
        //type 3
        Calculator calculators3 =s -> {return 0;};
        System.out.println(calculators3.sq(5));
    }*/
}
