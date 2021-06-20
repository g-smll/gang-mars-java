package gang.org.springframework.framework.bean;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/19 14:31
 */
public class GangAnnotatedGenericBeanDefinition extends GangGenericBeanDefinition implements GangAnnotatedBeanDefinition{

    public GangAnnotatedGenericBeanDefinition(Class beanClass){
        setBeanClass(beanClass);
    }
}
