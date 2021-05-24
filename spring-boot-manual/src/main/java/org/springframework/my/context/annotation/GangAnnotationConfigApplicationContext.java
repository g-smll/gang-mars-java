package org.springframework.my.context.annotation;

import org.springframework.my.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/24 8:43
 */
public class GangAnnotationConfigApplicationContext {

    private Class configClass;

    public GangAnnotationConfigApplicationContext(Class<?> configClass){
        this.configClass = configClass;

        //######################################
        //解析 ComponentScan ->com.gang.service
        //######################################
        ComponentScan declaredAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        String componentPath = declaredAnnotation.value();


        //######################################
        //类加载器知识，获取类加载器
        //类加载器：Bootstrap->jre/lib Ext->jre/ext/lib App->classpath->D:\work\learn\gang-mars-java\spring-boot-manual\target\classes
        //类加载器获取目录：com/gang/service，相关于classpath的路径
        //######################################
        String componentCategory = componentPath.replace(".","/");
        ClassLoader classLoader = GangAnnotationConfigApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(componentCategory);

        //######################################
        //获取class类文件目录
        //######################################
        assert resource != null;
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(f -> {
                try
                {
                    //############################################################################
                    //类加载器加载class文件，创建类
                    //classLoader.loadClass(className) className -> com.gang.service.UserService
                    //############################################################################
                    String absolutePath = f.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        String className = absolutePath.substring(absolutePath.indexOf("com"),absolutePath.indexOf(".class"));
                        className = className.replace("\\",".");
                        Class<?> aClass = classLoader.loadClass(className);
                        //判断类UserService注解了Component
                        if (aClass.isAnnotationPresent(Component.class)) {

                        }
                    }
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public Object getBean(String beanName){
        return null;
    }
}
