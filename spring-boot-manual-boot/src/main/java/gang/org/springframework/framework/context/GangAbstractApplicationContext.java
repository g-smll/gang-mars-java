package gang.org.springframework.framework.context;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import gang.org.springframework.framework.beanfactorypostprocessor.GangBeanFactoryPostProcessor;
import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;
import gang.org.springframework.framework.support.GangPostProcessorRegistrationDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/11 8:45
 */
public abstract class GangAbstractApplicationContext implements GangConfigurableApplicationContext {

    private final List<GangBeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<>();

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

    @Override
    public abstract GangConfigurableListableBeanFactory getBeanFactory();


    protected void prepareRefresh(){
    }

    protected GangConfigurableListableBeanFactory obtainFreshBeanFactory(){
        return getBeanFactory();
    }

    protected void prepareBeanFactory(GangConfigurableListableBeanFactory beanFactory){

    }

    protected void postProcessBeanFactory(GangConfigurableListableBeanFactory beanFactory){

    }

    /**
     * @param beanFactory {@link gang.org.springframework.framework.factory.GangDefaultListableBeanFactory}
     * */
    //TODO
    protected void invokeBeanFactoryPostProcessor(GangConfigurableListableBeanFactory beanFactory){
        GangPostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory,getBeanFactoryPostProcessors());
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

    @Override
    public String[] getBeanNamesForType(Class type, boolean includeNonSingletons, boolean allowEagerInit) {
        return null;
    }

    public List<GangBeanFactoryPostProcessor> getBeanFactoryPostProcessors(){
        return null;
    }

    //TODO
    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }

    //TODO
    public String[] getBeanDefinitionNames() {
        return null;
    }
}
