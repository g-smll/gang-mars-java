package com.gang.mars.bootstrap;

import com.gang.mars.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/22 13:11
 */

public class SystemPropertyConditionBootStrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(SystemPropertyConditionBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        System.out.printf("Bean -> " + context.getBean("helloWorld"));

        context.close();
    }

    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "ChenGang")
    public String helloWorld(){
        return "Hello, World 陈纲";
    }
}
