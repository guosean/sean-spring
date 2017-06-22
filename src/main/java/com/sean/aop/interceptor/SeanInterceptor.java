package com.sean.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by guozhenbin on 2017/5/5.
 */
public class SeanInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        Object[] args = methodInvocation.getArguments();
        System.out.println(String.format("method:%s,args:%s",method,args));
        if("modify".equals(method.getName())){

           return "拦截了"+methodInvocation.proceed();
        }
        return null;
    }
}
