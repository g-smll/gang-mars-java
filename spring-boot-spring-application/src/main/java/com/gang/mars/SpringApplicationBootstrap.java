package com.gang.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/23 13:24
 */
//@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        //SpringApplication.run(SpringApplicationBootstrapConfig.class,args);
        Set<String> sources = new HashSet<>();
        sources.add(SpringApplicationBootstrapConfig.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println(context.getBean(SpringApplicationBootstrapConfig.class));

    }

    @SpringBootApplication
    public static class SpringApplicationBootstrapConfig{

    }
}
