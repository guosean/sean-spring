package com.sean.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by guozhenbin on 2017/5/27.
 */
@Aspect
public class SystemArchitecture {

    @Pointcut("execution (* com.sean.aop.HelloWorld.sayHello(String))")
    public void sayHelloWithName(){};

}
