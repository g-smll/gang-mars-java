package gang.org.springframework.framework.factory;

import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;
import gang.org.springframework.framework.support.GangResolvableType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 13:56
 */
public class GangDefaultListableBeanFactory extends GangAbstractAutowireCapableBeanFactory implements GangConfigurableListableBeanFactory,GangBeanDefinitionRegistry {

    private volatile List<String> beanDefinitionNames = new ArrayList<>(256);

    private final Map<String,GangBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);


    @Override
    public void registerBeanDefinition(String beanName, GangBeanDefinition beanDefinition) {
        this.beanDefinitionNames.add(beanName);
        this.beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    public String[] getBeanNamesForType(Class type, boolean includeNonSingletons, boolean allowEagerInit) {
        return doGetBeanNamesForType(GangResolvableType.forRawClass(type),includeNonSingletons,true);
    }

    public String[] doGetBeanNamesForType(GangResolvableType type, boolean includeNonSingletons,boolean allowEagerInit){
        List<String> result = new ArrayList<>();
        for (String beanDefinitionName : this.beanDefinitionNames) {
            result.add(beanDefinitionName);
        }
        return result.stream().toArray(String[]::new);
    }
}
