package com.example.aop;

import com.example.HelloService;
import com.example.HelloServiceImpl;
import org.junit.jupiter.api.Test;

public class JdkDynamicProxyTest {
    @Test
    void test(){

        HelloService helloService = new HelloServiceImpl("hello fker");
        TargetSource targetSource = new TargetSource(helloService,HelloService.class);
        JdkDynamicAopProxy aopProxy = new JdkDynamicAopProxy(targetSource, new MyMethodInterceptor() );
        HelloService proxy = (HelloService) aopProxy.getProxy();
        proxy.sayFk();


    }
}
