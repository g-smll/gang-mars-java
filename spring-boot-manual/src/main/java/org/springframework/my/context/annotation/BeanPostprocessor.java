package org.springframework.my.context.annotation;

public interface BeanPostprocessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
