package com.gang.mars.bootstrap;

import com.gang.mars.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/20 8:25
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld 这是bean的名称
        String helloWorld =  context.getBean("helloWorld",String.class);

        System.out.println("helloWorld -> "+helloWorld);

        context.close();
    }
}
