package com.gang.mars.bootstrap;

import com.gang.mars.repository.GangFirstLevelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/19 18:42
 */
@ComponentScan("com.gang.mars.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);


        GangFirstLevelRepository gangFirstLevelRepository = context.getBean("gangFirstLevelRepository",GangFirstLevelRepository.class);

        System.out.println("gangFirstLevelRepository"+ gangFirstLevelRepository);

        context.close();
    }
}
