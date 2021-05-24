package com.gang.mars.aop.service;

import com.gang.mars.aop.enums.PersonEnum;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/18 14:35
 */
public interface HelloWorldService {
    public void say();

    public void hit();

    public void say(String name, PersonEnum personEnum);
}
