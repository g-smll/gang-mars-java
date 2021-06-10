package gang.org.springframework.boot;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

@FunctionalInterface
public interface GangApplicationContextFactory {

    GangApplicationContextFactory DEFAULT = ()->{
        return new GangAnnotationConfigServletWebServerApplicationContext();
    };

    GangConfigurableApplicationContext create();



}
