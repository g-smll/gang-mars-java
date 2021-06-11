package gang.org.springframework.boot;

import gang.org.springframework.framework.GangConfigurableApplicationContext;

@FunctionalInterface
public interface GangApplicationContextFactory {

    GangApplicationContextFactory DEFAULT = ()->{
        return new GangAnnotationConfigServletWebServerApplicationContext();
    };

    GangConfigurableApplicationContext create();



}
