package com.gang.mars.annotation;

import com.gang.mars.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * HelloWorld 模块激活
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld { //引用注解时，自行注册bean
}
