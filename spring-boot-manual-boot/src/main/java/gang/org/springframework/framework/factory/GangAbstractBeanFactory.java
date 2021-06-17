package gang.org.springframework.framework.factory;

import gang.org.springframework.framework.bean.GangAbstractBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangRootBeanDefinition;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/16 19:08
 */
public abstract class GangAbstractBeanFactory implements GangConfigurableBeanFactory{

    /**
     * @param requiredType {@link gang.org.springframework.framework.beanfactorypostprocessor.GangBeanDefinitionRegistryPostProcessor}
     * */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return doGetBean(name,requiredType,null,false);
    }

    protected <T> T doGetBean(String name,Class<T> requiredType, Object[] args, boolean typeCheckOnly){

        //todo
        String beanName = name;

        GangRootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName);

        return null;
    }

    protected GangRootBeanDefinition getMergedLocalBeanDefinition(String beanName){
        return getMergedBeanDefinition(beanName,getBeanDefinition(beanName));
    }

    protected GangRootBeanDefinition getMergedBeanDefinition(String beanName, GangBeanDefinition bd){
        return getMergedBeanDefinition(beanName,bd,null);
    }

    /**
     * @param bd class of bean is {@link gang.org.springframework.framework.beanfactorypostprocessor.GangConfigurationClassPostProcessor}
     * */
    protected GangRootBeanDefinition getMergedBeanDefinition(String beanName, GangBeanDefinition bd, GangBeanDefinition containingBd){
        GangRootBeanDefinition rootBeanDefinition = (GangRootBeanDefinition) ((GangRootBeanDefinition) bd).cloneBeanDefinition();

        return null;
    }

    protected abstract GangBeanDefinition getBeanDefinition(String beanName);
}
