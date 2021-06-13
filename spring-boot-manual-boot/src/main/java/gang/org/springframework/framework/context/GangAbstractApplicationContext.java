package gang.org.springframework.framework.context;

import gang.org.springframework.framework.GangConfigurableListableBeanFactory;
import gang.org.springframework.framework.context.GangConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/11 8:45
 */
public abstract class GangAbstractApplicationContext implements GangConfigurableApplicationContext {
    @Override
    public void refresh() {
        System.out.println("GangAbstractApplicationContext->refresh()-> running...");
        prepareRefresh();

        GangConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        prepareBeanFactory(beanFactory);

        try {
            postProcessBeanFactory(beanFactory);

            invokeBeanFactoryPostProcessor(beanFactory);

            registerBeanPostProcessors(beanFactory);

            initMessageSource();

            initApplicationEventMulticaster();

            onRefresh();

            registerListeners();

            finishBeanFactoryInitialization(beanFactory);

            finishRefresh();
            System.out.println("GangAbstractApplicationContext->refresh()-> end...");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void prepareRefresh(){
    }

    protected GangConfigurableListableBeanFactory obtainFreshBeanFactory(){
        return null;
    }

    protected void prepareBeanFactory(GangConfigurableListableBeanFactory beanFactory){

    }

    protected void postProcessBeanFactory(GangConfigurableListableBeanFactory beanFactory){

    }

    protected void invokeBeanFactoryPostProcessor(GangConfigurableListableBeanFactory beanFactory){

    }

    protected void registerBeanPostProcessors(GangConfigurableListableBeanFactory beanFactory){

    }

    protected void initMessageSource(){

    }

    protected void initApplicationEventMulticaster(){

    }

    protected void onRefresh(){

    }

    protected void registerListeners(){

    }

    protected void finishBeanFactoryInitialization(GangConfigurableListableBeanFactory beanFactory){

    }

    protected void finishRefresh(){

    }
}
