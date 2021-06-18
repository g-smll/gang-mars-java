package gang.org.springframework.framework.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/12 20:29
 */
public abstract class GangBeanUtils {

    public static <T> T instantiateClass(Constructor<T> ctor, Object args[]) throws Exception {
        try {
            return ctor.newInstance();
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new Exception("实例化对象异常...");
        }
    }
}
