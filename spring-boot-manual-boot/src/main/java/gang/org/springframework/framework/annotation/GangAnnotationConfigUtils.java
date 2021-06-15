package gang.org.springframework.framework.annotation;

import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinitionHolder;
import gang.org.springframework.framework.bean.GangRootBeanDefinition;
import gang.org.springframework.framework.beanfactorypostprocessor.GangConfigurationClassPostProcessor;
import gang.org.springframework.framework.context.GangGenericApplicationContext;
import gang.org.springframework.framework.factory.GangDefaultListableBeanFactory;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/13 18:18
 */
public abstract class GangAnnotationConfigUtils {

    public static final String CONFIGURATION_ANNOTATION_PROCESSOR_NAME="gang.org.springframework.framework.annotation.internalConfigurationAnnotationProcessor";

    public static void registerAnnotationConfigProcessors(GangBeanDefinitionRegistry registry){
        registerAnnotationConfigProcessors(registry,null);
    }

    public static Set<GangBeanDefinitionHolder> registerAnnotationConfigProcessors(GangBeanDefinitionRegistry registry,Object source){
        Set<GangBeanDefinitionHolder> beanDefs = new LinkedHashSet<>(8);
        GangRootBeanDefinition def = new GangRootBeanDefinition(GangConfigurationClassPostProcessor.class);
        def.setSource(source);
        beanDefs.add(registerPosProcessor(registry,def,CONFIGURATION_ANNOTATION_PROCESSOR_NAME));
        return beanDefs;
    }

    private static GangDefaultListableBeanFactory unwrapDefaultListableBeanFactory(GangBeanDefinitionRegistry registry){
        //return ((GangGenericApplicationContext)registry).getBeanFactory();
        return null;
    }

    private static GangBeanDefinitionHolder registerPosProcessor(GangBeanDefinitionRegistry registry, GangRootBeanDefinition definition,String beanName){
        definition.setRole(GangBeanDefinition.ROLE_INFRASTRUCTURE);
        registry.registerBeanDefinition(beanName,definition);
        return new GangBeanDefinitionHolder(definition,beanName);
    }


}
