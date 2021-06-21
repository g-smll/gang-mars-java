package gang.org.springframework.framework.support;

import gang.org.springframework.framework.bean.GangBeanDefinitionHolder;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/21 13:01
 */
public abstract class GangBeanDefinitionReaderUtils {

    //TODO
    public static void registerBeanDefinition(GangBeanDefinitionHolder definitionHolder,GangBeanDefinitionRegistry registry)
    {
        String beanName = definitionHolder.getBeanName();
        registry.registerBeanDefinition(beanName,definitionHolder.getBeanDefinition());
    }
}
