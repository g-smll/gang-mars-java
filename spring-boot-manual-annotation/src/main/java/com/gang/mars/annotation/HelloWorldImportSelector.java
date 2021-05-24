package com.gang.mars.annotation;

import com.gang.mars.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/21 8:49
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
