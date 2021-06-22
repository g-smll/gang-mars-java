package gang.org.springframework.framework.metadata;

import java.lang.annotation.Annotation;

public interface GangMergedAnnotations extends Iterable<GangMergedAnnotation<Annotation>> {

    enum SearchStrategy
    {
        DIRECT,

        INHERITED_ANNOTATIONS,

        SUPERCLASS,

        TYPE_HIERARCHY,

        TYPE_HIERARCHY_AND_ENCLOSING_CLASSES
    }
}
