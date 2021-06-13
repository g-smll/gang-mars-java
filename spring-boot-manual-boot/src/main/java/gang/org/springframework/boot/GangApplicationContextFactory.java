package gang.org.springframework.boot;

import gang.org.springframework.boot.context.GangAnnotationConfigServletWebServerApplicationContext;
import gang.org.springframework.framework.context.GangConfigurableApplicationContext;

@FunctionalInterface
public interface GangApplicationContextFactory {

    GangApplicationContextFactory DEFAULT = ()->{
        return new GangAnnotationConfigServletWebServerApplicationContext();
    };

    GangConfigurableApplicationContext create();



}
