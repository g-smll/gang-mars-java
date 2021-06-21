package gang.org.springframework.framework.beanfactorypostprocessor;

import com.gang.mars.boot.SpringbootManualApplication;
import gang.org.springframework.framework.annotation.GangConfigurationClassParser;
import gang.org.springframework.framework.bean.*;
import gang.org.springframework.framework.factory.GangConfigurableListableBeanFactory;
import gang.org.springframework.framework.support.GangBeanDefinitionRegistry;

import java.util.*;

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

        //TODO get value from registry; registry.getBeanDefinitionNames()
        System.out.println(registry.getBeanDefinitionNames());
        String candidateNames[] = (String[]) Arrays.asList("SpringbootManualApplication").toArray();

        for (String beanName : candidateNames) {

            //TODO get BeanDefinition from registry
            GangAnnotatedGenericBeanDefinition beanDef = new GangAnnotatedGenericBeanDefinition(SpringbootManualApplication.class);

            configCandidates.add(new GangBeanDefinitionHolder(beanDef,beanName));
        }

        //TODO
        GangConfigurationClassParser parser = new GangConfigurationClassParser(
                null,null,null,null,null,registry
        );

        Set<GangBeanDefinitionHolder> candidates = new LinkedHashSet<>(configCandidates);

        //TODO
        do{
            parser.parse(candidates);


            candidates.clear();
        }
        while (!candidates.isEmpty());
    }
}
