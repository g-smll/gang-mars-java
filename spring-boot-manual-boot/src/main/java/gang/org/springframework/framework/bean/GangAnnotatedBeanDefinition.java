package gang.org.springframework.framework.bean;

import gang.org.springframework.framework.metadata.GangAnnotationMetadata;

public interface GangAnnotatedBeanDefinition extends GangBeanDefinition
{
    GangAnnotationMetadata getMetadata();
}
