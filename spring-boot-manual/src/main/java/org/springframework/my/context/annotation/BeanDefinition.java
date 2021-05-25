package org.springframework.my.context.annotation;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/25 8:41
 */
public class BeanDefinition {

    private Class clazz;

    private String scope;

    /*public BeanDefinition(Class clazz, String scope) {
        this.clazz = clazz;
        this.scope = scope;
    }*/

    public Class getClazz() {
        return this.clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
