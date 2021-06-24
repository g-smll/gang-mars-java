package gang.org.springframework.framework.metadata;

import java.util.Map;

public interface GangAnnotatedTypeMetadata {

    default Map<String,Object> getAnnotationAttribute(String annotationName, boolean classValuesAsString)
    {
        return null;
    }
}
