package com.gang.mars.bootstrap;

import com.gang.mars.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/22 12:46
 */
@SpringBootApplication(scanBasePackages = "com.gang.mars.service")
public class CalculateServiceBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);

        System.out.println("calculateService ->" + calculateService);

        context.close();
    }
}
