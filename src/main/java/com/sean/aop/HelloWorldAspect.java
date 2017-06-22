package com.sean.aop;

import com.sean.context.SeanDriver;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * Created by guozhenbin on 2017/5/27.
 */

@Aspect
@Service
public class HelloWorldAspect {

    @Before(value = "execution(* com.sean.aop.HelloWorld.sayHello(String))")
    public void beforeSayHello(JoinPoint joinPoint){
        System.out.println("before say:"+joinPoint.getArgs()[0]);
//        System.out.println(name);
    }

    @Around("execution (* com.sean.aop.HelloWorld.sayHello(com.sean.context.SeanDriver))")
    public Object aroundSayHello(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        SeanDriver driver = (SeanDriver) objects[0];
        if(null!=driver && "sean".equals(driver.getName())){
            return "i driver";
        }
        return joinPoint.proceed();
    }

    @AfterReturning(
            pointcut = "com.sean.aop.SystemArchitecture.sayHelloWithName()",
            returning = "hellosean"
    )
    public void afterSayHello(JoinPoint joinPoint){
        System.out.println("after sayhello");
    }
}
