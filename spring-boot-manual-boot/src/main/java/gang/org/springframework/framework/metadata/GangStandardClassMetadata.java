package gang.org.springframework.framework.metadata;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/19 19:39
 */
public class GangStandardClassMetadata implements GangClassMetadata
{
    private final Class<?> introspectedClass;

    public GangStandardClassMetadata(Class<?> introspectedClass) {
        this.introspectedClass = introspectedClass;
    }

    public final Class<?> getIntrospectedClass() {
        return this.introspectedClass;
    }
}
