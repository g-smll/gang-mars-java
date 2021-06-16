package gang.org.springframework.framework.bean;

public interface GangBeanDefinition {

    int ROLE_INFRASTRUCTURE = 2;

    void setRole(int role);

    String getScope();
}
