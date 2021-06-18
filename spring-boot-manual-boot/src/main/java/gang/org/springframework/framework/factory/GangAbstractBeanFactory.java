package gang.org.springframework.framework.factory;

import gang.org.springframework.framework.bean.GangAbstractBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangRootBeanDefinition;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/16 19:08
 */
public abstract class GangAbstractBeanFactory extends GangFactoryBeanRegistrySupport implements GangConfigurableBeanFactory{

    /**
     * @param requiredType {@link gang.org.springframework.framework.beanfactorypostprocessor.GangBeanDefinitionRegistryPostProcessor}
     * */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return doGetBean(name,requiredType,null,false);
    }

    protected <T> T doGetBean(String name,Class<T> requiredType, Object[] args, boolean typeCheckOnly){

        //TODO
        String beanName = name;

        GangRootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName);

        if (mbd.isSingleton()) {
            //TODO
            Object sharedInstance = getSingleton(beanName, () -> {
                return createBean(beanName,mbd,args);
            });
        }


        return null;
    }

    protected GangRootBeanDefinition getMergedLocalBeanDefinition(String beanName){
        return getMergedBeanDefinition(beanName,getBeanDefinition(beanName));
    }

    protected GangRootBeanDefinition getMergedBeanDefinition(String beanName, GangBeanDefinition bd){
        return getMergedBeanDefinition(beanName,bd,null);
    }

    /**
     * @param bd is instance to class of {@link GangRootBeanDefinition}
     * */
    protected GangRootBeanDefinition getMergedBeanDefinition(String beanName, GangBeanDefinition bd, GangBeanDefinition containingBd){

        // GangBeanDefinition instance is GangRootBeanDefinition as
        GangRootBeanDefinition rootBeanDefinition = ((GangRootBeanDefinition) bd).cloneBeanDefinition();

        rootBeanDefinition.setScope(SCOPE_SINGLETON);
        return rootBeanDefinition;
    }

    protected abstract GangBeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, GangRootBeanDefinition mbd, Object[] args);


}
