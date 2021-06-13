package gang.org.springframework.framework.annotation;

import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/13 11:53
 */
public class GangAnnotatedBeanDefinitionReader {

    private final GangBeanDefinitionRegistry registry;

    public GangAnnotatedBeanDefinitionReader(GangBeanDefinitionRegistry registry){
        this(registry,null);
    }

    /**
     * @param registry 入参上下文对象
     * @param environment 暂时不编码实现（变理）
     * */
    public GangAnnotatedBeanDefinitionReader(GangBeanDefinitionRegistry registry, Object environment){
        this.registry = registry;
    }
}
