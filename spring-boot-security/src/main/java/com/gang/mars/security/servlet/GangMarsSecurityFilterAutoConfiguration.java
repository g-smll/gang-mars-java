package com.gang.mars.security.servlet;

import com.gang.mars.security.context.properties.GangMarsEnableConfigurationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/5 8:43
 */
@Configuration(proxyBeanMethods = false)
public class GangMarsSecurityFilterAutoConfiguration {

    private static final String DEFAULT_FILTER_NAME = "gangMarsSpringSecurityFilterChain";

    @Bean
    //条件装配，当spring 容器中有对象gangMarsSpringSecurityFilterChain时执行
    @ConditionalOnBean(name = DEFAULT_FILTER_NAME)
    public DelegatingFilterProxyRegistrationBean GangMarsSecurityFilterChainRegistration(
            SecurityProperties securityProperties) {
        DelegatingFilterProxyRegistrationBean registration = new DelegatingFilterProxyRegistrationBean(
                DEFAULT_FILTER_NAME);
        registration.setOrder(securityProperties.getFilter().getOrder());
        registration.setDispatcherTypes(getDispatcherTypes(securityProperties));
        return registration;
    }

    private EnumSet<DispatcherType> getDispatcherTypes(SecurityProperties securityProperties) {
        if (securityProperties.getFilter().getDispatcherTypes() == null) {
            return null;
        }
        return securityProperties.getFilter().getDispatcherTypes().stream()
                .map((type) -> DispatcherType.valueOf(type.name()))
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(DispatcherType.class)));
    }

}
