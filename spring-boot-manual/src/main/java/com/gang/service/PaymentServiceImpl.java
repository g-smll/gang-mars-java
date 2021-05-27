package com.gang.service;

import org.springframework.my.stereotype.Component;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/26 12:26
 */
@Component("paymentService")
public class PaymentServiceImpl implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PaymentServiceImpl->afterPropertiesSet-> ###");
    }
}
