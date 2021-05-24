package com.gang.mars.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/20 8:21
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld () { //方法名即Bean的名字
        return "Hello, World";
    }
}
