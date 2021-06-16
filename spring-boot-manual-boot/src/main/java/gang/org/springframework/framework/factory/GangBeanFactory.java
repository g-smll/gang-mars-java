package gang.org.springframework.framework.factory;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 13:54
 */
public interface GangBeanFactory {

    <T> T getBean(String name, Class<T> requiredType);
}
