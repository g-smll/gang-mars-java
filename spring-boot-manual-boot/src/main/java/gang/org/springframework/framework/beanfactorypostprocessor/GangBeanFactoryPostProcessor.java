package gang.org.springframework.framework.beanfactorypostprocessor;

import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;

@FunctionalInterface
public interface GangBeanFactoryPostProcessor {
    void postProcessBeanFactory(GangConfigurableListableBeanFactory beanFactory);
}
