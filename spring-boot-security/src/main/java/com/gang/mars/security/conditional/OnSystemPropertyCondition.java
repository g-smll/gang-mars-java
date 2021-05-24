package com.gang.mars.security.conditional;

import lombok.val;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/4 19:12
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Map<String, Object> map = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        return false;
    }
}
