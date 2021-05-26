package com.gang.service;

import org.springframework.my.context.annotation.BeanNameAware;
import org.springframework.my.stereotype.Component;

/**
 * @author gang.chen
 * @description 实践Aware
 * @time 2021/5/26 9:26
 */
@Component("invoiceService")
public class InvoiceServiceImpl implements InvoiceService, BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
