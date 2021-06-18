package gang.org.springframework.framework.support;

import gang.org.springframework.framework.beanfactorypostprocessor.GangBeanDefinitionRegistryPostProcessor;
import gang.org.springframework.framework.beanfactorypostprocessor.GangBeanFactoryPostProcessor;
import gang.org.springframework.framework.beanfactorypostprocessor.GangConfigurationClassPostProcessor;
import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/15 12:30
 */
public final class GangPostProcessorRegistrationDelegate {

    /**
     * @param beanFactory {@link gang.org.springframework.framework.factory.GangDefaultListableBeanFactory}
     * */
    public static void invokeBeanFactoryPostProcessors(GangConfigurableListableBeanFactory beanFactory, List<GangBeanFactoryPostProcessor> beanFactoryPostProcessors)
    {
        GangBeanDefinitionRegistry registry = (GangBeanDefinitionRegistry) beanFactory;

        List<GangBeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();

        String[] postProcessorNames = beanFactory.getBeanNamesForType(GangBeanDefinitionRegistryPostProcessor.class,true,false);

        for (String postProcessorName : postProcessorNames) {
            //todo Spring IOC instance bean
            //beanFactoryPostProcessor = beanFactory.getBean(postProcessorName,GangBeanDefinitionRegistryPostProcessor.class)
            //currentRegistryProcessors.add(beanFactoryPostProcessor);
            GangConfigurationClassPostProcessor beanFactoryPostProcessor = new GangConfigurationClassPostProcessor();
            currentRegistryProcessors.add(beanFactoryPostProcessor);
        }

        invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors,registry,null);
    }

    /**
     * @param postProcessors any instances which impl GangBeanDefinitionRegistryPostProcessor interface
     *                       reference to {@link GangBeanDefinitionRegistryPostProcessor}
     *
     * @param registry {@link gang.org.springframework.framework.factory.GangDefaultListableBeanFactory}
     * */
    private static void invokeBeanDefinitionRegistryPostProcessors(Collection<GangBeanDefinitionRegistryPostProcessor> postProcessors, GangBeanDefinitionRegistry registry, Object applicationStartup)
    {
        for (GangBeanDefinitionRegistryPostProcessor postProcessor : postProcessors) {
            postProcessor.postProcessBeanDefinitionRegistry(registry);
        }
    }
}
