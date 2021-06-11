package gang.org.springframework.boot;

/**
 * @author gang.chen
 * @description 启动类
 * @time 2021/6/10 8:50
 */
public class GangSpringApplication {


    private GangApplicationContextFactory applicationContextFactory = GangApplicationContextFactory.DEFAULT;


    public static  GangConfigurableApplicationContext run (Class<?> primaryClass, String ... args){

        return new GangSpringApplication().doRun(primaryClass,args);
    }

    public GangConfigurableApplicationContext doRun(Class<?> primaryClass, String ... args){

        System.out.println("GangSpringApplication-> starting ...");

        GangConfigurableApplicationContext context = null;


        context = createApplicationContext();


        return null;
    }

    protected GangConfigurableApplicationContext createApplicationContext(){
        return this.applicationContextFactory.create();
    }

    private void refreshContext(){

    }

    private void refresh(GangConfigurableApplicationContext context){
        context.refresh();
    }
}
