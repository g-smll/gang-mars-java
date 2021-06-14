package gang.org.springframework.framework.bean;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 20:36
 */
public class GangAbstractBeanDefinition extends GangBeanMetadataAttributeAccessor implements GangBeanDefinition{

    private int role = GangBeanDefinition.ROLE_INFRASTRUCTURE;

    private volatile Object beanClass;

    @Override
    public void setRole(int role) {
        this.role = role;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }
}
