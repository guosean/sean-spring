package com.sean.aop;

import com.sean.context.SeanDriver;
import org.springframework.stereotype.Service;

/**
 * Created by guozhenbin on 2017/5/27.
 */
@Service
public class HelloWorld implements IHelloWorld {

    public String sayHello(String name) {
        System.out.println("hello:"+name);
        return "hello"+name;
    }

    public String sayHello(SeanDriver driver){
        return "say driver:"+driver.getName();
    }

}
