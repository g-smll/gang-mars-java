package com.gang.mars.security.config.annotation.web.configuration;

import com.gang.mars.security.config.annotation.web.builders.GangMarsHttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/31 14:01
 */
@Configuration(proxyBeanMethods = false)
public class GangMarsHttpSecurityConfiguration {

    private ObjectPostProcessor<Object> objectPostProcessor;

    @Autowired
    void setObjectPostProcessor(ObjectPostProcessor<Object> objectPostProcessor) {
        this.objectPostProcessor = objectPostProcessor;
    }

    private static final String BEAN_NAME_PREFIX = "com.gang.mars.security.config.annotation.web.configuration.HttpSecurityConfiguration.";
    private static final String HTTP_SECURITY_BEAN_NAME = BEAN_NAME_PREFIX + "gangMarsHttpSecurity";
    @Bean(name = HTTP_SECURITY_BEAN_NAME)
    GangMarsHttpSecurity gangMarsHttpSecurity(){

        GangMarsHttpSecurity gangMarsHttpSecurity = new GangMarsHttpSecurity(objectPostProcessor);


        return null;
    }
}
