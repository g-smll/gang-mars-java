package com.gang.mars.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author gang.chen
 * @description
 * @time 2020/12/18 14:37
 */
@Aspect
@Component
public class HelloWorldServiceAspect {

    @Pointcut("within(com.gang.mars.aop.service..*)")
    public void inServiceLayer() {
    }

    @Before("inServiceLayer()")
    public void beforeInServiceLayer(){
        System.out.println("HelloWorldServiceAspect -> beforeInServiceLayer");
    }

    /**
     * execution(* com.gang.mars.aop.service.impl.HelloWorldServiceImpl.hit()) 切入没有参数方法
     * execution(* com.gang.mars.aop.service.impl.HelloWorldServiceImpl.hit(.)) 有一个参数的方法
     * execution(* com.gang.mars.aop.service.impl.HelloWorldServiceImpl.hit(..)) 一个或多个参数
     *
     * execution(* com.gang.mars.aop.service.impl.HelloWorldServiceImpl.hit(..)) *
     * execution(public com.gang.mars.aop.service.impl.HelloWorldServiceImpl.hit(..)) * 修饰符 public
     *
     * @target(org.springframework.transaction.annotation.transactional ) 现实类transactional会被切入
     * @args(org.springframework.transaction.annotation.transactional)
     * @with(org.springframework.transaction.annotation.transactional)
     */
    @Before("execution(* com.gang.mars.aop.service.impl.HelloWorldServiceImpl.hit(..))")
    public void before(){
        System.out.println("HelloWorldServiceAspect -> before hit");
    }

    @Pointcut("@annotation(com.gang.mars.aop.annotation.CustomizeAnnotation)")
    public void cutLayer(){}

    @Before("cutLayer()")
    public void beforeCutLayer(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println(joinPoint);
    }

}
