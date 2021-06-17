package gang.org.springframework.framework.factory;

@FunctionalInterface
public interface GangObjectFactory<T> {
    T getObject();
}
