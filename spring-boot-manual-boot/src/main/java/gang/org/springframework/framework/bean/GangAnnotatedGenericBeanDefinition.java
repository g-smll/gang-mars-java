package gang.org.springframework.framework.bean;

import gang.org.springframework.framework.metadata.GangAnnotationMetadata;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/19 14:31
 */
public class GangAnnotatedGenericBeanDefinition extends GangGenericBeanDefinition implements GangAnnotatedBeanDefinition{

    private final GangAnnotationMetadata metadata;

    public GangAnnotatedGenericBeanDefinition(Class beanClass)
    {
        setBeanClass(beanClass);
        this.metadata = GangAnnotationMetadata.introspect(beanClass);
    }

    @Override
    public final GangAnnotationMetadata getMetadata()
    {
        return this.metadata;
    }
}
