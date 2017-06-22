package com.sean.aop;

import com.sean.context.SeanDriver;

/**
 * Created by guozhenbin on 2017/5/27.
 */
public class HelloWorld2 extends HelloWorld{

    public String sayHello(String name) {
        System.out.println("hello 2:"+name);
        return "hello name";
    }

    public String sayHello(SeanDriver driver){
        return "say driver 2:"+driver.getName();
    }

}
