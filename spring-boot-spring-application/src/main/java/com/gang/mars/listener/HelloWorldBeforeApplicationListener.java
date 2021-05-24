package com.gang.mars.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/23 15:07
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldBeforeApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("before -> HelloWorldBeforeApplicationListener->"+event.getApplicationContext().getId()+"; timestamp ->" + event.getTimestamp());
    }
}
