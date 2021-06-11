package gang.org.springframework.boot;

import gang.org.springframework.framework.GangConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description 启动类
 * @time 2021/6/10 8:50
 */
public class GangSpringApplication {


    private GangApplicationContextFactory applicationContextFactory = GangApplicationContextFactory.DEFAULT;


    public static GangConfigurableApplicationContext run (Class<?> primaryClass, String ... args){

        return new GangSpringApplication().doRun(primaryClass,args);
    }

    public GangConfigurableApplicationContext doRun(Class<?> primaryClass, String ... args){

        System.out.println("GangSpringApplication-> starting ...");

        GangConfigurableApplicationContext context = null;

        GangSpringApplicationRunListeners listeners = getRunListeners(args);

        listeners.starting(null,null);

        try
        {
            GangApplicationArguments applicationArguments = new GangDefaultApplicationArguments(args);

            context = createApplicationContext();

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

}
