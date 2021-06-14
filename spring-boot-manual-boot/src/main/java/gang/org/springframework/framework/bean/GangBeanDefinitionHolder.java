package gang.org.springframework.framework.bean;

public class GangBeanDefinitionHolder {
    private final GangBeanDefinition beanDefinition;
    private final String beanName;
    private final String[] aliases;

    public GangBeanDefinitionHolder(GangBeanDefinition beanDefinition, String beanName){
        this(beanDefinition,beanName,null);
    }

    public GangBeanDefinitionHolder(GangBeanDefinition beanDefinition, String beanName, String[] aliases){
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
        this.aliases = aliases;
    }
}
