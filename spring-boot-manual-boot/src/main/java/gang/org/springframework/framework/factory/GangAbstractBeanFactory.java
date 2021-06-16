package gang.org.springframework.framework.factory;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/16 19:08
 */
public abstract class GangAbstractBeanFactory implements GangConfigurableBeanFactory{
    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }

    protected <T> T doGetBean(String name,Class<T> requiredType, Object[] args, boolean typeCheckOnly){

        //todo
        String beanName = name;
        return null;
    }
}
