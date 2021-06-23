package gang.org.springframework.framework.annotation;

import gang.org.springframework.framework.io.GangResource;
import gang.org.springframework.framework.metadata.GangAnnotationMetadata;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/23 8:30
 */
public class GangConfigurationClass
{
    private String beanName;
    private final GangResource resource;
    private final GangAnnotationMetadata metadata;

    public GangConfigurationClass(String beanName, GangAnnotationMetadata metadata) {
        this.beanName = beanName;
        this.metadata = metadata;
        this.resource = null;
    }

    public GangAnnotationMetadata getMetadata() {
        return this.metadata;
    }
}
