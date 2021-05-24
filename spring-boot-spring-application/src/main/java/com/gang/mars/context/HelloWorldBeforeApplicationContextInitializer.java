package com.gang.mars.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/23 14:30
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldBeforeApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>, Ordered {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("before -> HelloWorldBeforeApplicationContextInitializer#applicationContext.getId()->" + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
