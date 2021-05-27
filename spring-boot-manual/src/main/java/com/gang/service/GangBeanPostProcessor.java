package com.gang.service;

import org.springframework.my.context.annotation.BeanPostprocessor;
import org.springframework.my.stereotype.Component;

/**
 * @author gang.chen
 * @description Bean 增加
 * @time 2021/5/26 12:39
 */
@Component
public class GangBeanPostProcessor implements BeanPostprocessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("GangBeanPostProcessor->postProcessBeforeInitialization->"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("GangBeanPostProcessor->postProcessAfterInitialization->"+bean);
        return bean;
    }
}
