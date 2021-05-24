package com.gang.mars.security.context.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(GangMarsEnableConfigurationPropertiesRegistrar.class)
public @interface GangMarsEnableConfigurationProperties {

    /**
     * The bean name of the configuration properties validator.
     * @since 2.2.0
     */
    String VALIDATOR_BEAN_NAME = "configurationPropertiesValidator";

    /**
     * Convenient way to quickly register
     * {@link ConfigurationProperties @ConfigurationProperties} annotated beans with
     * Spring. Standard Spring Beans will also be scanned regardless of this value.
     * @return {@code @ConfigurationProperties} annotated beans to register
     */
    Class<?>[] value() default {};
}
