package com.gang.mars.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/23 15:17
 */
public class HelloWorldAfterApplicationListener implements ApplicationListener<ContextRefreshedEvent> , Ordered
{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("after -> HelloWorldAfterApplicationListener->"+event.getApplicationContext().getId()+"; timestamp ->" + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
