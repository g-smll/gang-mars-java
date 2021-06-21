package gang.org.springframework.framework.bean;

import gang.org.springframework.framework.factory.GangConfigurableBeanFactory;

public interface GangBeanDefinition {

    int ROLE_INFRASTRUCTURE = 2;

    void setRole(int role);

    String getScope();

    boolean isSingleton();

    String SCOPE_SINGLETON = GangConfigurableBeanFactory.SCOPE_SINGLETON;

    String getBeanClassName();
}
