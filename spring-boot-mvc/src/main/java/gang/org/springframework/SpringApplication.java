package gang.org.springframework;

import gang.org.springframework.servlet.DispatcherServlet;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * @author gang.chen
 * @description 启动类
 * @time 2021/5/27 8:33
 */
public class SpringApplication {


    public static void run(Class<?> primarySource, String... args){
        tomcatOn();
        startTomcat();
    }

    public static void startTomcat() {
        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8080);

        StandardEngine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        StandardHost host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());



        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);
        tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet());
        context.addServletMappingDecoded("/*","dispatcher");

        try{
            tomcat.start();
            tomcat.getServer().await();
        }
        catch (LifecycleException e){
            e.printStackTrace();
        }
    }

    public static void tomcatOn(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("", "D:\\work\\learn\\gang-mars-java\\docBase");
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
