package gang.org.springframework.boot.loader;

import gang.org.springframework.framework.annotation.GangAnnotatedBeanDefinitionReader;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/20 20:56
 */
public class GangBeanDefinitionLoader
{
    private final Object[] sources;

    private final GangAnnotatedBeanDefinitionReader annotatedReader;

    /**
     * @param registry {@link gang.org.springframework.framework.factory.GangDefaultListableBeanFactory}
     * @param sources {@link com.gang.mars.boot.SpringbootManualApplication}
     * */
    public GangBeanDefinitionLoader(GangBeanDefinitionRegistry registry, Object... sources)
    {
        this.annotatedReader = new GangAnnotatedBeanDefinitionReader(registry);
        this.sources =sources;
    }

    public void load()
    {
        for (Object source : this.sources) {
            load(source);
        }
    }

    //TODO
    private void load(Object source)
    {
        load((Class<?>) source);
    }

    //TODO
    private void load(Class<?> source){
        this.annotatedReader.register(source);
    }
}
