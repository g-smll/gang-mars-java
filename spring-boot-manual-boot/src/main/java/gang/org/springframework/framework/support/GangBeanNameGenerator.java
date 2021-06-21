package gang.org.springframework.framework.support;

import gang.org.springframework.framework.bean.GangBeanDefinition;

public interface GangBeanNameGenerator {

    String generateBeanName(GangBeanDefinition definition, GangBeanDefinitionRegistry registry);
}
