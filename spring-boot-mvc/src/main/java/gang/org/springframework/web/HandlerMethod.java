package gang.org.springframework.web;

import java.lang.reflect.Method;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/31 13:13
 */
public class HandlerMethod {
    private Object bean;
    private Method method;

    public HandlerMethod(Object bean, Method method) {
        this.bean = bean;
        this.method = method;
    }

    public Object getBean() {
        return this.bean;
    }

    public Method getMethod() {
        return this.method;
    }
}
