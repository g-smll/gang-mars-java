package gang.org.springframework.web;

import com.gang.mars.mvc.config.SpringMvcConfig;
import gang.org.springframework.annotation.ComponentScan;
import gang.org.springframework.annotation.Controller;
import gang.org.springframework.annotation.RequestMapping;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @author gang.chen
 * @description RequestMappingHandlerMapping
 * @time 2021/5/31 7:45
 */
public class RequestMappingHandlerMapping {

    Set<Class<?>> classes = new HashSet();
    HashMap<String, HandlerMethod> registry = new HashMap<>();


    public void initHandlerMappings(){
        System.out.println("RequestMappingHandlerMapping->initHandlerMappings() #####初始化开始####");
        Set<Class<?>> aClasses = scan(SpringMvcConfig.class);
        aClasses.forEach(c->{
            Method[] declaredMethods = c.getDeclaredMethods();
            Arrays.stream(declaredMethods).forEach(m->{
                RequestMapping declaredRequestMapping = m.getDeclaredAnnotation(RequestMapping.class);
                if (declaredRequestMapping !=null) {
                    String urlMapping = declaredRequestMapping.value();
                    registry.put(urlMapping,new HandlerMethod(newInstance(c),m));
                    System.out.println(registry);
                }

            });
        });
        System.out.println("RequestMappingHandlerMapping->initHandlerMappings() #####初始化结束####");
    }

    public Set<Class<?>> scan(Class config){
        ComponentScan declaredAnnotation = (ComponentScan) config.getDeclaredAnnotation(ComponentScan.class);
        String componentPath = declaredAnnotation.value();
        String componentCategory = componentPath.replace(".","/");
        ClassLoader classLoader = RequestMappingHandlerMapping.class.getClassLoader();
        URL resource = classLoader.getResource(componentCategory);
        assert resource != null;
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(f->{
                String absolutePath = f.getAbsolutePath();
                if (absolutePath.endsWith(".class")) {
                    String className = absolutePath.substring(absolutePath.indexOf("com"),absolutePath.indexOf(".class"));
                    className = className.replace("\\",".");
                    try {
                        Class<?> aClass = classLoader.loadClass(className);
                        if (aClass.isAnnotationPresent(Controller.class)) {
                            classes.add(aClass);
                        }
                    }
                    catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return classes;
    }

    private Object newInstance(Class clazz){
        try {
            return clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HandlerMethod getHandlerMethod(String url){
        return registry.get(url);
    }
}
