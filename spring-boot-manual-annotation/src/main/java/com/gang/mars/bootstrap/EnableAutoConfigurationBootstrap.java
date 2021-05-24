package com.gang.mars.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/22 13:38
 */

@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("bean ->" + context.getBean("helloWorld"));

        context.close();
    }
}
