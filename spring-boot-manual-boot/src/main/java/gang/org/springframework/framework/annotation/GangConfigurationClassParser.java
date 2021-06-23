package gang.org.springframework.framework.annotation;

import gang.org.springframework.boot.autoconfigure.GImport;
import gang.org.springframework.boot.autoconfigure.GangDeferredImportSelector;
import gang.org.springframework.framework.bean.GangAnnotatedBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinitionHolder;
import gang.org.springframework.framework.metadata.GangAnnotationMetadata;
import gang.org.springframework.framework.metadata.GangStandardAnnotationMetadata;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/19 13:43
 */
public class GangConfigurationClassParser {

    private final DeferredImportSelectorHandler deferredImportSelectorHandler = new DeferredImportSelectorHandler();

    //TODO
    public GangConfigurationClassParser(Object metadataReaderFactory,
                                        Object problemReport,
                                        Object environment,
                                        Object resourceLoader,
                                        Object componentScanBeanNameGenerator,
                                        GangBeanDefinitionRegistry registry)
    {

    }

    //TODO
    public void parse(Set<GangBeanDefinitionHolder> configCandidates)
    {
        for (GangBeanDefinitionHolder holder : configCandidates) {

            GangBeanDefinition bd = holder.getBeanDefinition();

            if (bd instanceof GangAnnotatedBeanDefinition)
            {
                parse(((GangAnnotatedBeanDefinition)bd).getMetadata(),holder.getBeanName());
            }
        }
    }

    //TODO
    protected final void parse(GangAnnotationMetadata metadata, String beanName)
    {
        processConfigurationClass(new GangConfigurationClass(beanName,metadata),null);
    }

    //TODO
    protected void processConfigurationClass(GangConfigurationClass configClass, Object filter)
    {
        GangSourceClass sourceClass = asSourceClass(configClass, null);
        doProcessConfigurationClass(configClass,sourceClass,null);
    }

    //TODO
    protected final Object doProcessConfigurationClass(GangConfigurationClass configClass, GangSourceClass sourceClass, Object filter)
    {
        //Process any @Import annotations
        processImports(configClass,sourceClass,getImports(sourceClass),null,true);
        return null;
    }

    //TODO
    private void processImports(GangConfigurationClass configClass, GangSourceClass currentSourceClass, Collection<GangSourceClass> importCandidates, Object exclusionClass, boolean checkForCircularImports)
    {
        this.deferredImportSelectorHandler.handle(null,null);

    }

    private class DeferredImportSelectorHandler{

        public void handle(Object configClass, Object importSelector)
        {
            DeferredImportSelectorGroupingHandler handler = new DeferredImportSelectorGroupingHandler();
            handler.processGroupImport();
        }
    }

    private class DeferredImportSelectorHolder
    {
        private final Object configurationClass;
        private final Object importSelector;

        public DeferredImportSelectorHolder(Object configurationClass, Object importSelector) {
            this.configurationClass = configurationClass;
            this.importSelector = importSelector;
        }
    }

    private class DeferredImportSelectorGroupingHandler
    {
        private final Map<Object, DeferredImportSelectorGrouping> groupings = new LinkedHashMap<>();

        public void processGroupImport()
        {
            for (DeferredImportSelectorGrouping grouping : this.groupings.values()) {
                grouping.getImport();
            }
        }
    }

    private static class DeferredImportSelectorGrouping
    {
        private final GangDeferredImportSelector.Group group;

        private final List<DeferredImportSelectorHolder> deferredImports = new ArrayList<>();

        public DeferredImportSelectorGrouping(GangDeferredImportSelector.Group group)
        {
            this.group = group;
        }

        public Iterable<GangDeferredImportSelector.Group.Entry> getImport(){

            for (DeferredImportSelectorHolder deferredImport : this.deferredImports) {
                this.group.process(null,null);
            }
            return null;
        }
    }

    //TODO
    private class GangSourceClass
    {
        private final Object source;
        private final GangAnnotationMetadata metadata;

        public GangSourceClass(Object source) {
            this.source = source;
            this.metadata = GangAnnotationMetadata.introspect((Class<?>)source);
        }

        //TODO
        public Set<GangSourceClass> getAnnotations()
        {
            Set<GangSourceClass> result = new LinkedHashSet<>();
            if (this.source instanceof Class) {
                Class<?> sourceClass = (Class<?>) this.source;
                for (Annotation ann : sourceClass.getDeclaredAnnotations())
                {
                    Class<? extends Annotation> anyType = ann.annotationType();
                    String name = anyType.getName();
                    //#######################################################
                    //JDK原生注解过滤，比如 java.lang.annotation.Target
                    //#######################################################
                    if (!name.startsWith("java"))
                    {
                        result.add(asSourceClass(anyType,null));
                    }
                }
            }
            return result;
        }

        public GangAnnotationMetadata getMetadata() {
            return this.metadata;
        }
    }

    //TODO
    private GangSourceClass asSourceClass(GangConfigurationClass configurationClass, Object filter)
    {
        GangAnnotationMetadata metadata = configurationClass.getMetadata();
        if (metadata instanceof GangStandardAnnotationMetadata) {
            return asSourceClass(((GangStandardAnnotationMetadata)metadata).getIntrospectedClass(),null);
        }
        return null;
    }

    //TODO
    GangSourceClass asSourceClass(Class<?> classType, Object filter)
    {
        return new GangSourceClass(classType);
    }

    private Set<GangSourceClass> getImports(GangSourceClass sourceClass)
    {
        Set<GangSourceClass> imports = new LinkedHashSet<>();
        Set<GangSourceClass> visited = new LinkedHashSet<>();
        collectImports(sourceClass,imports,visited);
        return imports;
    }

    //TODO
    private void collectImports(GangSourceClass sourceClass,Set<GangSourceClass> imports, Set<GangSourceClass> visited)
    {
        if (visited.add(sourceClass))
        {
            Set<GangSourceClass> gangSourceClasses = sourceClass.getAnnotations();
            for (GangSourceClass annotation : gangSourceClasses)
            {
                String annName = annotation.getMetadata().getClassName();
                if (!annName.equals(GImport.class.getName())) {
                    collectImports(annotation,imports,visited);
                }
            }
        }
    }


}
