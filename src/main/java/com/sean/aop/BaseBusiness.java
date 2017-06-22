package com.sean.aop;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@EnableAspectJAutoProxy
@Service
public class BaseBusiness implements IBaseBusiness {

    /**
     * 切入点
     */
    @Before("baseBeforeAdvice")
    @org.aspectj.lang.annotation.Pointcut
    public String delete(String obj) {
        System.out.println("==========调用切入点：" + obj + "说：你敢删除我！===========\n");
        return obj + "：瞄～";
    }

    public String add(String obj) {
        System.out.println("================这个方法不能被切。。。============== \n");
        return obj + "：瞄～ 嘿嘿！";
    }

    @Before("baseBeforeAdvice")
    @Pointcut
    public String modify(String obj) {
        System.out.println("=================这个也设置加入切吧====================\n");
        return obj + "：瞄改瞄啊！";
    }

}
