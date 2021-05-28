package gang.org.springframework;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

/**
 * @author gang.chen
 * @description 启动类
 * @time 2021/5/27 8:33
 */
public class SpringApplication {


    public static void run(Class<?> primarySource, String... args){
        tomcatOn();
    }

    public static void tomcatOn(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
        try {
            context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
            tomcat.start();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | LifecycleException e) {
            e.printStackTrace();
        }


        System.out.println("tomcat 8080 启动完成...");
        tomcat.getServer().await();
    }
}
