package gang.org.springframework.framework.beanfactorypostprocessor;

import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 21:08
 */
public class GangConfigurationClassPostProcessor implements GangBeanDefinitionRegistryPostProcessor {

    /**
     * @param registry {@link gang.org.springframework.framework.factory.GangDefaultListableBeanFactory}
     * */
    @Override
    public void postProcessBeanDefinitionRegistry(GangBeanDefinitionRegistry registry)
    {
        processConfigBeanDefinitions(registry);
    }

    @Override
    public void postProcessBeanFactory(GangConfigurableListableBeanFactory beanFactory)
    {

    }

    public void processConfigBeanDefinitions(GangBeanDefinitionRegistry registry)
    {

    }
}
