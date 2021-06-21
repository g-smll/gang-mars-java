package gang.org.springframework.framework.annotation;

import gang.org.springframework.framework.bean.GangAnnotatedGenericBeanDefinition;
import gang.org.springframework.framework.support.GangAnnotationBeanNameGenerator;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;
import gang.org.springframework.framework.support.GangBeanNameGenerator;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/13 11:53
 */
public class GangAnnotatedBeanDefinitionReader {

    private final GangBeanDefinitionRegistry registry;

    private GangBeanNameGenerator beanNameGenerator = GangAnnotationBeanNameGenerator.INSTANCE;

    /**
     * @param registry {@link gang.org.springframework.boot.context.GangAnnotationConfigServletWebServerApplicationContext}
     * */
    public GangAnnotatedBeanDefinitionReader(GangBeanDefinitionRegistry registry){
        this(registry,null);
    }

    /**
     * @param registry 入参上下文对象
     * @param environment 暂时不编码实现
     * */
    public GangAnnotatedBeanDefinitionReader(GangBeanDefinitionRegistry registry, Object environment){
        this.registry = registry;
        GangAnnotationConfigUtils.registerAnnotationConfigProcessors(registry);
    }

    //TODO
    public void register(Class<?>... componentClasses)
    {
        for (Class<?> componentClass : componentClasses)
        {
            registerBean(componentClass);
        }
    }

    //TODO
    public void registerBean(Class<?> beanClass)
    {
        doRegisterBean(beanClass,null,null,null,null);
    }

    //TODO
    private <T> void doRegisterBean(Class<T> beanClass,String name, Object[] qualifiers,Object supplier,Object customizers)
    {
        GangAnnotatedGenericBeanDefinition abd = new GangAnnotatedGenericBeanDefinition(beanClass);

        String beanName = beanNameGenerator.generateBeanName(abd, this.registry);
    }
}
