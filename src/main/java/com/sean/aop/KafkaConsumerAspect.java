package com.sean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * Created by guozhenbin on 2017/6/2.
 */

@Aspect
@Service
public class KafkaConsumerAspect {

    @Before(value = "execution(* org.apache.kafka.clients.consumer.internals.Fetcher.initFetches(..))")
    public void beforeFetchResponse(JoinPoint joinPoint){

        System.out.println("before say:"+joinPoint.getArgs()[0]);
    }
}
