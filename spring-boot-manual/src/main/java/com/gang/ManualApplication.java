package com.gang;

import com.gang.config.AppConfig;
import org.springframework.my.context.annotation.GangAnnotationConfigApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/24 13:15
 */
public class ManualApplication {
    public static void main(String[] args) {
        GangAnnotationConfigApplicationContext context = new GangAnnotationConfigApplicationContext(AppConfig.class);
        Object userService = context.getBean("userService");
        //System.out.println(userService);
    }
}
