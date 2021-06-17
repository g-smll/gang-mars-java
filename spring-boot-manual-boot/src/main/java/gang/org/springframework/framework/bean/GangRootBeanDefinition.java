package gang.org.springframework.framework.bean;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 20:36
 */
public class GangRootBeanDefinition extends GangAbstractBeanDefinition {

    public GangRootBeanDefinition(Class beanClass){
        setBeanClass(beanClass);
    }

    @Override
    public GangRootBeanDefinition cloneBeanDefinition() {
        return new GangRootBeanDefinition(this);
    }

    public GangRootBeanDefinition(GangRootBeanDefinition original){
        //TODO
        super(original);
    }


}
