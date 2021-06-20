package gang.org.springframework.boot.autoconfigure;

import gang.org.springframework.framework.metadata.GangAnnotationMetadata;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/20 14:24
 */
public class GangAutoConfigurationImportSelector implements GangDeferredImportSelector {


    private static class AutoConfigurationGroup implements GangDeferredImportSelector.Group{

        @Override
        public void process(GangAnnotationMetadata metadata, GangDeferredImportSelector selector) {
            System.out.println("GangAutoConfigurationImportSelector->process->自动装配开始...");
        }
    }
}

