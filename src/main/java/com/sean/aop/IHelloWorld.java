package com.sean.aop;

import com.sean.context.SeanDriver;

/**
 * Created by guozhenbin on 2017/5/27.
 */
public interface IHelloWorld {

    String sayHello(String name);

    String sayHello(SeanDriver driver);

}
