package com.gang.mars.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/23 14:37
 */
public class HelloWorldAfterApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("after ->HelloWorldAfterApplicationContextInitializer#applicationContext.getId()->" + applicationContext.getId());
    }
}
