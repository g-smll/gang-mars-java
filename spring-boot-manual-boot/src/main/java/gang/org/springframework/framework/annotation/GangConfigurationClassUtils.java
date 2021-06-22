package gang.org.springframework.framework.annotation;

import gang.org.springframework.framework.bean.GangAnnotatedBeanDefinition;
import gang.org.springframework.framework.bean.GangBeanDefinition;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/22 13:31
 */
public abstract class GangConfigurationClassUtils {

    //TODO
    public static boolean checkConfigurationClassCandidate(GangBeanDefinition beanDef, Object metadataReaderFactory)
    {
        if (beanDef instanceof GangAnnotatedBeanDefinition) {
            return true;
        }
        return false;
    }
}
