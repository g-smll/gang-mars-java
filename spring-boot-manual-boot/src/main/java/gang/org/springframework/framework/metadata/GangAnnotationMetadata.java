package gang.org.springframework.framework.metadata;

public interface GangAnnotationMetadata extends GangClassMetadata,GangAnnotatedTypeMetadata {


    /**
     * @param type {@link Class}
     * */
    static GangAnnotationMetadata introspect(Class<?> type)
    {
        return GangStandardAnnotationMetadata.from(type);
    }
}
