package gang.org.springframework.framework.factory;

public interface GangListableBeanFactory extends GangBeanFactory{
    String[] getBeanNameForType(Class type, boolean includeNonSingletons, boolean allowEagerInit);
}
