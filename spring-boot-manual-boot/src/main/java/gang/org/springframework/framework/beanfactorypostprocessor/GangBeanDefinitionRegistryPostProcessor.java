package gang.org.springframework.framework.beanfactorypostprocessor;

import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

public interface GangBeanDefinitionRegistryPostProcessor extends GangBeanFactoryPostProcessor
{
    void postProcessBeanDefinitionRegistry(GangBeanDefinitionRegistry registry);
}
