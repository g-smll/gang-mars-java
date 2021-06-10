package gang.org.springframework.boot;

/**
 * @author gang.chen
 * @description 启动类
 * @time 2021/6/10 8:50
 */
public class GangSpringApplication {


    private GangApplicationContextFactory applicationContextFactory = GangApplicationContextFactory.DEFAULT;

    public static GangConfigurableApplicationContext run(Class<?> primaryClass, String ... args){

        System.out.println("GangSpringApplication-> starting ...");

        //GangConfigurableApplicationContext gangConfigurableApplicationContext = applicationContextFactory.create();
        return null;
    }
}
