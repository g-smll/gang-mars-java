package gang.org.springframework.boot;

import gang.org.springframework.boot.loader.GangBeanDefinitionLoader;
import gang.org.springframework.framework.context.GangApplicationContext;
import gang.org.springframework.framework.context.GangConfigurableApplicationContext;
import gang.org.springframework.framework.GangResourceLoader;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

import java.util.*;

/**
 * @author gang.chen
 * @description 启动类
 * @time 2021/6/10 8:50
 */
public class GangSpringApplication {

    private GangResourceLoader resourceLoader;

    private Set<Class<?>> primarySource;

    private GangWebApplicationType webApplicationType;

    private List<GangApplicationContextInitializer<?>> initializers;


    //#############################################################
    //GangApplicationContextFactory
    //函数式接口，获取函数式接口本身
    //#############################################################
    private GangApplicationContextFactory applicationContextFactory = GangApplicationContextFactory.DEFAULT;


    public GangSpringApplication(Class<?>... primarySource){
        this(null,primarySource);
    }

    //TODO
    public GangSpringApplication(GangResourceLoader resourceLoader, Class<?>... primarySource){
        this.primarySource = new LinkedHashSet<>(Arrays.asList(primarySource));
    }



    public static GangConfigurableApplicationContext run (Class<?> primaryClass, String ... args){
        return new GangSpringApplication(primaryClass).run(args);
    }



    public GangConfigurableApplicationContext run(String[] args){

        System.out.println("GangSpringApplication-> starting ...");

        GangConfigurableApplicationContext context = null;

        GangSpringApplicationRunListeners listeners = getRunListeners(args);

        listeners.starting(null,null);

        try
        {
            GangApplicationArguments applicationArguments = new GangDefaultApplicationArguments(args);

            context = createApplicationContext();

            prepareContext(null,context,null,null,null,null);

            //#############################################################
            //refreshContext
            //Spring IOC 入口中
            //#############################################################
            refreshContext(context);

            afterRefresh(context,applicationArguments);

            listeners.started(context);

            listeners.running(context);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("GangSpringApplication-> end ...");
        return context;
    }

    protected GangConfigurableApplicationContext createApplicationContext(){
        return this.applicationContextFactory.create();
    }

    private void refreshContext(GangConfigurableApplicationContext context){
        refresh(context);
    }

    private void refresh(GangConfigurableApplicationContext context){
        context.refresh();
    }

    private void afterRefresh(GangConfigurableApplicationContext context, GangApplicationArguments args){

    }

    private GangSpringApplicationRunListeners getRunListeners(String[] args){
        return new GangSpringApplicationRunListeners();
    }

    public void setInitializers(Collection<? extends GangApplicationContextInitializer<?>> initializers){
        this.initializers = new ArrayList(initializers);
    }


    //TODO
    /**
     * @param context {@link gang.org.springframework.boot.context.GangAnnotationConfigServletWebServerApplicationContext}
     * */
    private void prepareContext(Object bootstrapContext,
                                GangConfigurableApplicationContext context,
                                Object environment,
                                Object listeners,
                                Object applicationArguments,
                                Object printedBanner)
    {

        Set<Object> sources = getAllSources();
        load(context,sources.toArray(new Object[0]));
    }

    public Set<Object> getAllSources(){
        Set<Object> allSource = new LinkedHashSet<>();
        allSource.addAll(this.primarySource);
        return allSource;
    }

    //TODO
    private GangBeanDefinitionRegistry getBeanDefinitionRegistry(GangApplicationContext context){
        return (GangBeanDefinitionRegistry) context;
    }

    //TODO
    /**
     * @param sources {@link com.gang.mars.boot.SpringbootManualApplication}
     * @param context {@link gang.org.springframework.boot.context.GangAnnotationConfigServletWebServerApplicationContext}
     * */
    protected void load(GangApplicationContext context, Object[] sources)
    {
        GangBeanDefinitionLoader loader = createBeanDefinitionLoader(getBeanDefinitionRegistry(context),sources);
        loader.load();

    }

    protected GangBeanDefinitionLoader createBeanDefinitionLoader(GangBeanDefinitionRegistry registry, Object[] sources){
        return new GangBeanDefinitionLoader(registry,sources);
    }
}
