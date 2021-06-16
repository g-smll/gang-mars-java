package com.gang.mars.basic.resolvaletype;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/15 18:51
 */
public class ResolvableType implements Serializable {

    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forRawClass(c1.class);
        System.out.println(resolvableType);
    }

    private Class<?> resolved;
    private final Type type;

    public ResolvableType[] getGenerics(){
        System.out.println("getGenerics->getGenerics()" );
        return null;
    }

    public boolean isAssignableFrom(Class other){
        System.out.println("isAssignableFrom(Class other)");
        return true;
    }

    public boolean isAssignableFrom(ResolvableType other){
        System.out.println("isAssignableFrom(ResolvableType other)");
        return true;
    }

    private ResolvableType(Class<?> clazz){
        this.resolved = clazz;
        this.type = resolved;
    }


    public static ResolvableType forRawClass(Class<?> clazz){
        return new ResolvableType(clazz){
            @Override
            public ResolvableType[] getGenerics() {
                return super.getGenerics();
            }

            @Override
            public boolean isAssignableFrom(Class other) {
                return super.isAssignableFrom(other);
            }

            @Override
            public boolean isAssignableFrom(ResolvableType other) {
                return super.isAssignableFrom(other);
            }
        };
    }
}

class c1{
    String name = "gang";
}
