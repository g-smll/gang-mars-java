package com.gang.mars.test;

import com.gang.mars.test.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/27 19:25
 */
public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext
                = new AnnotationConfigApplicationContext();

        System.out.println("myself ->" + configApplicationContext);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
