package com.gang.mars.aop.service.impl;

import com.gang.mars.aop.annotation.CustomizeAnnotation;
import com.gang.mars.aop.enums.PersonEnum;
import com.gang.mars.aop.service.HelloWorldService;
import org.springframework.stereotype.Component;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/18 14:36
 */
@Component
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void say() {
        System.out.println("HelloWorldServiceImpl -> say() hello world");
    }

    @Override
    public void hit() {
        System.out.println("HelloWorldServiceImpl -> hit() hit world");
    }

    @Override
    @CustomizeAnnotation(name = "#name",personEnum = PersonEnum.FEMALE)
    public void say(String name, PersonEnum personEnum) {
        System.out.println(name);
        System.out.println(personEnum);
    }
}
