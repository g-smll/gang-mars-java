package com.gang.mars.security.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 条件装配
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    String name();
    String value();
}
