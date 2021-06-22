package gang.org.springframework.framework.metadata;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/19 19:36
 */
public class GangStandardAnnotationMetadata extends GangStandardClassMetadata implements GangAnnotationMetadata
{
    private final GangMergedAnnotations mergedAnnotations;
    private final boolean nestedAnnotationsAsMap;

    public GangStandardAnnotationMetadata(Class<?> introspectedClass, boolean nestedAnnotationsAsMap)
    {
        this.mergedAnnotations = null;
        this.nestedAnnotationsAsMap= nestedAnnotationsAsMap;
    }

    static GangAnnotationMetadata from(Class<?> introspectedClass)
    {
        return new GangStandardAnnotationMetadata(introspectedClass,true);
    }
}
