package gang.org.springframework.framework.bean;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 20:36
 */
public abstract class GangAbstractBeanDefinition extends GangBeanMetadataAttributeAccessor implements GangBeanDefinition{

    private int role = GangBeanDefinition.ROLE_INFRASTRUCTURE;

    public static final String SCOPE_DEFAULT = "";

    private volatile Object beanClass;

    private String scope = SCOPE_DEFAULT;

    protected GangAbstractBeanDefinition() {
    }

    public abstract GangAbstractBeanDefinition cloneBeanDefinition();

    protected GangAbstractBeanDefinition (GangBeanDefinition original){
        this.beanClass = original.getClass();
    }

    @Override
    public void setRole(int role) {
        this.role = role;
    }



    @Override
    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public Object getBeanClass() {
        return this.beanClass;
    }
}
