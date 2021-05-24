package com.gang.mars.security.config.annotation.web.builders;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;

import javax.servlet.Filter;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/31 13:56
 */
public class GangMarsHttpSecurity extends AbstractConfiguredSecurityBuilder<DefaultSecurityFilterChain, HttpSecurity> implements SecurityBuilder<DefaultSecurityFilterChain>, HttpSecurityBuilder<HttpSecurity>
{
    private String version = "1";
    private String author = "gang.chen";

    public GangMarsHttpSecurity(ObjectPostProcessor<Object> objectPostProcessor) {
        super(objectPostProcessor);
    }

    protected GangMarsHttpSecurity(ObjectPostProcessor<Object> objectPostProcessor, boolean allowConfigurersOfSameType) {
        super(objectPostProcessor, allowConfigurersOfSameType);
    }


    @Override
    protected DefaultSecurityFilterChain performBuild() throws Exception {
        return null;
    }

    @Override
    public HttpSecurity authenticationProvider(AuthenticationProvider authenticationProvider) {
        return null;
    }

    @Override
    public HttpSecurity userDetailsService(UserDetailsService userDetailsService) throws Exception {
        return null;
    }

    @Override
    public HttpSecurity addFilterAfter(Filter filter, Class<? extends Filter> afterFilter) {
        return null;
    }

    @Override
    public HttpSecurity addFilterBefore(Filter filter, Class<? extends Filter> beforeFilter) {
        return null;
    }

    @Override
    public HttpSecurity addFilter(Filter filter) {
        return null;
    }
}
