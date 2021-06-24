package gang.org.springframework.framework.metadata;

import java.util.Map;

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
        super(introspectedClass);
        //####################################################
        //重点
        //####################################################
        this.mergedAnnotations = null;
        this.nestedAnnotationsAsMap= nestedAnnotationsAsMap;
    }

    public static GangAnnotationMetadata from(Class<?> introspectedClass)
    {
        return new GangStandardAnnotationMetadata(introspectedClass,true);
    }

    @Override
    public Map<String, Object> getAnnotationAttribute(String annotationName, boolean classValuesAsString) {
        if (this.nestedAnnotationsAsMap)
        {

        }
        return null;
    }
}
