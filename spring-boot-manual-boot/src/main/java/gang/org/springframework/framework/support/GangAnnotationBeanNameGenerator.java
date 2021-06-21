package gang.org.springframework.framework.support;

import gang.org.springframework.framework.bean.GangBeanDefinition;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/20 22:38
 */
public class GangAnnotationBeanNameGenerator implements GangBeanNameGenerator
{
    public static final GangAnnotationBeanNameGenerator INSTANCE = new GangAnnotationBeanNameGenerator();

    @Override
    public String generateBeanName(GangBeanDefinition definition, GangBeanDefinitionRegistry registry)
    {
        return null;
    }

    protected String buildDefaultBeanName(GangBeanDefinition definition)
    {
        String beanName = definition.getBeanClassName();
        return null;
    }
}
