package gang.org.springframework.framework.support;

import gang.org.springframework.framework.bean.GangBeanDefinition;

public interface GangBeanDefinitionRegistry extends GangAliasRegistry {

    void registerBeanDefinition(String beanName, GangBeanDefinition beanDefinition);
}
