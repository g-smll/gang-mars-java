package gang.org.springframework.framework.beanfactorypostprocessor;

import gang.org.springframework.framework.GangConfigurableListableBeanFactory;

@FunctionalInterface
public interface GangBeanFactoryPostProcessor {
    void postProcessBeanFactory(GangConfigurableListableBeanFactory beanFactory);
}
