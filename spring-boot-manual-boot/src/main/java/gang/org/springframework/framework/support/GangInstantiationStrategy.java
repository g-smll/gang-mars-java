package gang.org.springframework.framework.support;

import gang.org.springframework.framework.bean.GangRootBeanDefinition;
import gang.org.springframework.framework.factory.GangBeanFactory;

public interface GangInstantiationStrategy {

    Object instantiate(GangRootBeanDefinition md, String beanName, GangBeanFactory owner);
}
