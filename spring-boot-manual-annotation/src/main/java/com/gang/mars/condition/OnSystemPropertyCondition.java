package com.gang.mars.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/22 13:03
 */
public class OnSystemPropertyCondition implements Condition {

    /**
     * @param context 上下文
     * @param metadata 元信息
     * */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = String.valueOf(annotationAttributes.get("name"));
        String value = String.valueOf(annotationAttributes.get("value"));
        String systemName = System.getProperty(name);
        System.out.printf("systemName -> " + systemName);
        return value.equals(systemName);
    }
}
