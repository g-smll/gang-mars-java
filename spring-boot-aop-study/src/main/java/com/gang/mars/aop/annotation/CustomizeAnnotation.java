package com.gang.mars.aop.annotation;

import com.gang.mars.aop.enums.PersonEnum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CustomizeAnnotation {

    /**
     * @return name
     */
    String name();

    /**
     * return PersonEnum
     */
    PersonEnum personEnum();
}
