package gang.org.springframework.boot;

import gang.org.springframework.framework.context.GangConfigurableApplicationContext;

public interface GangApplicationContextInitializer<C extends GangConfigurableApplicationContext> {

    void initialize(C applicationContext);
}
