package com.gang.mars.security.servlet;

import com.gang.mars.security.config.annotation.web.builders.GangMarsHttpSecurity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/31 13:48
 */
@Configuration(proxyBeanMethods = false)

public class GangMarsSpringBootWebSecurityConfiguration {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain GangMarsDefaultSecurityFilterChain(GangMarsHttpSecurity httpSecurity) throws Exception {
        System.out.println("GangMarsSpringBootWebSecurityConfiguration->GangMarsDefaultSecurityFilterChain");
        System.out.println(httpSecurity);
        return null;
    }
}
