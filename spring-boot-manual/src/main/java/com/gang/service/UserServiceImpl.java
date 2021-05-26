package com.gang.service;

import org.springframework.my.context.annotation.Autowired;
import org.springframework.my.stereotype.Component;

/**
 * @author gang.chen
 * @description 实践注入
 * @time 2021/5/24 12:39
 */
//@Scope("prototype")
@Component("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private OrderService orderService;

    @Override
    public void smokeTest() {
        System.out.println("UserServiceImpl->smokeTest() "+orderService);
    }
}
