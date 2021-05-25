package com.gang;

import com.gang.config.AppConfig;
import com.gang.service.UserService;
import org.springframework.my.context.annotation.GangAnnotationConfigApplicationContext;

/**
 * @author gang.chen
 * @description main function
 * @time 2021/5/24 13:15
 */
public class ManualApplication {
    public static void main(String[] args) {
        GangAnnotationConfigApplicationContext context = new GangAnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.smokeTest();
    }
}
