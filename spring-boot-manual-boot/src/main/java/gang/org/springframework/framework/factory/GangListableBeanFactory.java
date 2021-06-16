package gang.org.springframework.framework.factory;

public interface GangListableBeanFactory extends GangBeanFactory{

    String[] getBeanNamesForType(Class type, boolean includeNonSingletons, boolean allowEagerInit);
}
