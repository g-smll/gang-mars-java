package org.springframework.my.context.annotation;

import org.springframework.my.stereotype.Component;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/24 8:43
 */
public class GangAnnotationConfigApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public GangAnnotationConfigApplicationContext(Class<?> configClass){
        scan(configClass);
        beanDefinitionMap.forEach((k,v) ->{
            if (v.getScope().equals("singleton")) {
                Object bean = createBean(k,v);
                singletonObjects.put(k,bean);
            }else{
                //TODO TBD
            }
        });
    }

    public Object createBean(String beanName, BeanDefinition beanDefinition){
        Class clazz = beanDefinition.getClazz();
        try {
            //#################################################################
            //Spring 通过构造器，实例对象代码实现
            //Object instance = clazz.getConstructor().newInstance();
            //#################################################################
            Object instance = clazz.getDeclaredConstructor().newInstance();

            //#################################################################
            //需要实现依赖注入
            //#################################################################
            return instance;
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void scan(Class<?> configClass) {
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
                        Class<?> clazz = classLoader.loadClass(className);
                        //####################################
                        //1,创建BeanDefinition
                        //####################################
                        if (clazz.isAnnotationPresent(Component.class)) {
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            BeanDefinition beanDefinition = new BeanDefinition();
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            }else{
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinition.setClazz(clazz);
                            beanDefinitionMap.put(beanName,beanDefinition);
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
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(beanDefinition.getScope().equals("singleton")){
                return singletonObjects.get(beanName);
            }else{
                return createBean(beanName,beanDefinition);
            }
        }else {
            throw new NullPointerException();
        }
    }
}
