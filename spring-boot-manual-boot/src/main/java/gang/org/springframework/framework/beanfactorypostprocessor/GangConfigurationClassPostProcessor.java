package gang.org.springframework.framework.beanfactorypostprocessor;

import gang.org.springframework.framework.annotation.GangConfigurationClassParser;
import gang.org.springframework.framework.annotation.GangConfigurationClassUtils;
import gang.org.springframework.framework.bean.GangBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinitionHolder;
import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/14 21:08
 */
public class GangConfigurationClassPostProcessor implements GangBeanDefinitionRegistryPostProcessor {

    /**
     * @param registry {@link gang.org.springframework.framework.factory.GangDefaultListableBeanFactory}
     * */
    @Override
    public void postProcessBeanDefinitionRegistry(GangBeanDefinitionRegistry registry)
    {
        processConfigBeanDefinitions(registry);
    }

    @Override
    public void postProcessBeanFactory(GangConfigurableListableBeanFactory beanFactory)
    {

    }

    public void processConfigBeanDefinitions(GangBeanDefinitionRegistry registry)
    {
        List<GangBeanDefinitionHolder> configCandidates = new ArrayList<>();

        String[] candidateNames = registry.getBeanDefinitionNames();
        for (String beanName : candidateNames) {

            GangBeanDefinition beanDef = registry.getBeanDefinition(beanName);

            if (GangConfigurationClassUtils.checkConfigurationClassCandidate(beanDef,null)) {
                configCandidates.add(new GangBeanDefinitionHolder(beanDef,beanName));
            }
        }

        //TODO
        GangConfigurationClassParser parser = new GangConfigurationClassParser(
                null,null,null,null,null,registry
        );

        Set<GangBeanDefinitionHolder> candidates = new LinkedHashSet<>(configCandidates);

        //TODO
        do {
            parser.parse(candidates);

            candidates.clear();
        }
        while (!candidates.isEmpty());
    }
}
