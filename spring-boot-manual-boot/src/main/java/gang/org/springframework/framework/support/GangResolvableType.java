package gang.org.springframework.framework.support;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/15 18:46
 */
public class GangResolvableType implements Serializable {

    private Class<?> resolved;
    private final Type type;

    private GangResolvableType(Class<?> clazz){
        this.resolved = clazz;
        this.type = resolved;
    }


    public static GangResolvableType forRawClass(Class<?> clazz){
        return new GangResolvableType(clazz);
    }

}
