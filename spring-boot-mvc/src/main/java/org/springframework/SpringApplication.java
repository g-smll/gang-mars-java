package org.springframework;

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

        tomcat.getServer().await();
    }
}
