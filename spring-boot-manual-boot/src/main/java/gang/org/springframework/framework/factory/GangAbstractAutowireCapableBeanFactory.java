package gang.org.springframework.framework.factory;

import gang.org.springframework.framework.bean.GangBeanWrapper;
import gang.org.springframework.framework.bean.GangRootBeanDefinition;
import gang.org.springframework.framework.support.GangInstantiationStrategy;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/16 19:09
 */
public abstract class GangAbstractAutowireCapableBeanFactory extends GangAbstractBeanFactory {

    private GangInstantiationStrategy instantiationStrategy;

    @Override
    protected Object createBean(String beanName, GangRootBeanDefinition mbd, Object[] args) {
        //TODO
        Object object = doCreateBean(beanName,mbd,args);

        return object;
    }

    protected Object doCreateBean(String beanName, GangRootBeanDefinition mbd, Object[] args){
        GangBeanWrapper instanceWrapper = createBeanWrapper(beanName,mbd,args);

        //TODO

        //Object obj = instanceWrapper.getWrappedInstance()

        return null;
    }

    protected GangBeanWrapper createBeanWrapper(String beanName, GangRootBeanDefinition mbd, Object[] args){
        return instantiateBean(beanName,mbd);
    }

    protected GangBeanWrapper instantiateBean(String beanName, GangRootBeanDefinition mbd){
        //TODO
        Object beanInstance = getInstantiationStrategy().instantiate(mbd,beanName,this);

        GangBeanWrapper beanWrapper = null;

        return beanWrapper;
    }

    public GangInstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }
}
