package com.gang.mars.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author gang.chen
 * @description
 * @time 2020/9/29 14:55
 */
@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService () {
        final InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager();
        final UserDetails userDetails = User.withUsername("Mr.gang")
                .password("123456")
                .authorities("read")
                .build();
        uds.createUser(userDetails);
        return uds;
    }
}
