package gang.org.springframework.framework.context;

import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;
import gang.org.springframework.framework.factory.GangDefaultListableBeanFactory;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/13 22:21
 */
public class GangGenericApplicationContext extends GangAbstractApplicationContext implements GangBeanDefinitionRegistry {

    private final GangDefaultListableBeanFactory beanFactory;

    public GangGenericApplicationContext(){
        beanFactory = new GangDefaultListableBeanFactory();
    }

    @Override
    public void registerBeanDefinition(String beanName, GangBeanDefinition beanDefinition) {
        beanFactory.registerBeanDefinition(beanName,beanDefinition);
    }


    @Override
    public GangConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
