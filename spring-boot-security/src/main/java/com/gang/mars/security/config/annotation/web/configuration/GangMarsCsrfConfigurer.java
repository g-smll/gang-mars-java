package com.gang.mars.security.config.annotation.web.configuration;

import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/5 13:46
 */
public class GangMarsCsrfConfigurer <H extends HttpSecurityBuilder<H>> extends AbstractHttpConfigurer<CsrfConfigurer<H>, H> {
}
