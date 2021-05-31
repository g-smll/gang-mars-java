package gang.org.springframework.web;

import com.gang.mars.mvc.config.SpringMvcConfig;
import gang.org.springframework.annotation.ComponentScan;
import gang.org.springframework.annotation.Controller;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author gang.chen
 * @description RequestMappingHandlerMapping
 * @time 2021/5/31 7:45
 */
public class RequestMappingHandlerMapping {

    Set<Class<?>> classes = new HashSet();


    public void initHandlerMappings(){
        System.out.println("RequestMappingHandlerMapping->initHandlerMappings() #####初始化####");
        Set<Class<?>> aClasses = scan(SpringMvcConfig.class);
        System.out.println(aClasses);
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
}
