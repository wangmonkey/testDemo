package com.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @version ： 1.0.0
 * @package : com.aop
 * @progect : testDemo
 * @Description :
 * @Created by : wangxueyang[wxueyanghj@163.com]
 * @Creation Date ：2018年10月22日11:36 PM
 */
public class WxecutionTimeLoggingSpringAOP
        implements MethodBeforeAdvice ,AfterReturningAdvice{
   long startTime = 0;

    @Override
    public void afterReturning(@Nullable Object o, Method method, Object[] objects, @Nullable Object target) throws Throwable {
        long elaspedTime = System.nanoTime() - startTime;
        String canonicalName = target.getClass().getCanonicalName();
        String name = method.getName();
        System.out.println(name + "exec " + elaspedTime);
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        startTime = System.nanoTime();
    }
}
