package com.gang.mars.annotation;

import com.gang.mars.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/22 13:40
 */
@Configuration //模式注解
@EnableHelloWorld //spring @Enable 模块装配
@ConditionalOnSystemProperty(name="user.name", value = "ChenGang") //条件装配
public class HelloWorldAutoConfiguration {
}
