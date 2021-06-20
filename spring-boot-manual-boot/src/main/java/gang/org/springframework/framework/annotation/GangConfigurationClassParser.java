package gang.org.springframework.framework.annotation;

import gang.org.springframework.boot.autoconfigure.GangDeferredImportSelector;
import gang.org.springframework.framework.bean.GangAnnotatedBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinitionHolder;
import gang.org.springframework.framework.metadata.GangAnnotationMetadata;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

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

            if (bd instanceof GangAnnotatedBeanDefinition) {
                parse(null,null);
            }
        }
    }

    protected final void parse(GangAnnotationMetadata metadata, String beanName)
    {
        processConfigurationClass(null,null);
    }

    protected void processConfigurationClass(Object configClass, Object filter){
        doProcessConfigurationClass(null,null,null);
    }

    protected final Object doProcessConfigurationClass(Object configClass, Object sourceClass, Object filter){
        //Process any @Import annotations
        processImports(null,null,null,null,true);
        return null;
    }

    private void processImports(Object configClass, Object currentSourceClass, Object importCandidates, Object exclusionClass, boolean checkForCircularImports)
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


}
