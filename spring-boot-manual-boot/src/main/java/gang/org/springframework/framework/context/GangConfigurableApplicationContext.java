package gang.org.springframework.framework.context;

import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;

public interface GangConfigurableApplicationContext extends GangApplicationContext{
    void refresh();

    GangConfigurableListableBeanFactory getBeanFactory();
}
