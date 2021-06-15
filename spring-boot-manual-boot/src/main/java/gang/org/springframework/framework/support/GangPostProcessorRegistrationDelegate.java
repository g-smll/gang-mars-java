package gang.org.springframework.framework.support;

import gang.org.springframework.framework.beanfactorypostprocessor.GangBeanDefinitionRegistryPostProcessor;
import gang.org.springframework.framework.beanfactorypostprocessor.GangBeanFactoryPostProcessor;
import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/15 12:30
 */
public final class GangPostProcessorRegistrationDelegate {

    public static void invokeBeanFactoryPostProcessors(GangConfigurableListableBeanFactory beanFactory, List<GangBeanFactoryPostProcessor> beanFactoryPostProcessors){
        List<GangBeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();

    }
}
