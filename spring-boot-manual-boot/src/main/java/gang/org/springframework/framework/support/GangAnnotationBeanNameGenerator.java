package gang.org.springframework.framework.support;

import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanUtils;
import gang.org.springframework.framework.util.GangClassUtil;

import java.beans.Introspector;

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
        return buildDefaultBeanName(definition,registry);
    }

    protected String buildDefaultBeanName(GangBeanDefinition definition,GangBeanDefinitionRegistry registry)
    {
        return buildDefaultBeanName(definition);
    }

    //TODO
    protected String buildDefaultBeanName(GangBeanDefinition definition){
        String beanClassName = definition.getBeanClassName();
        String shortClassName = GangClassUtil.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
}
