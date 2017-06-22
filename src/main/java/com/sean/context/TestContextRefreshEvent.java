package com.sean.context;

import joptsimple.internal.Strings;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by guozhenbin on 2017/6/9.
 */
@Component
public class TestContextRefreshEvent implements ApplicationListener<ContextRefreshedEvent>{

    public TestContextRefreshEvent(){
        System.out.println(String.format("TestContextRefreshEvent construct"));
    }

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(Strings.join(event.getApplicationContext().getBeanDefinitionNames(),","));
        System.out.println("ApplicationListener:"+event);
    }
}
