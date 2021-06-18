package gang.org.springframework.framework.factory;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/17 13:29
 */
public class GangDefaultSingletonBeanRegistry implements GangSingletonBeanRegistry{

    public Object getSingleton(String beanName, GangObjectFactory<?> singletonFactory){

        Object singletonObject = singletonFactory.getObject();

        return singletonObject;
    }
}
