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

    }

    private Class<?> resolved;
    private final Type type;

    private ResolvableType(Class<?> clazz){
        this.resolved = clazz;
        this.type = resolved;
    }


    public static ResolvableType forRawClass(Class<?> clazz){
        return null;
    }
}
