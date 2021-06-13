package gang.org.springframework.boot.context;

import gang.org.springframework.framework.GangServletWebServerApplicationContext;
import gang.org.springframework.framework.annotation.GangAnnotatedBeanDefinitionReader;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/10 13:03
 */
public class GangAnnotationConfigServletWebServerApplicationContext extends GangServletWebServerApplicationContext
{
    private final GangAnnotatedBeanDefinitionReader reader;

    public GangAnnotationConfigServletWebServerApplicationContext() {
        this.reader = new GangAnnotatedBeanDefinitionReader(this);
    }
}
