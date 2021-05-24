package com.gang.mars.aop;

import com.gang.mars.aop.enums.PersonEnum;
import com.gang.mars.aop.service.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/18 14:31
 */
@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        HelloWorldService helloWorldService = context.getBean(HelloWorldService.class);
        helloWorldService.say();
        helloWorldService.hit();

        helloWorldService.say("gang.chen", PersonEnum.MALE);

    }
}
