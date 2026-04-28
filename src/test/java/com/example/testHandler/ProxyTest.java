package com.example.testHandler;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void simpleTest(){
        TestHelloImpl hello = new TestHelloImpl();
        TestHello proxy = (TestHello) Proxy.newProxyInstance(TestHello.class.getClassLoader(),
                new Class[]{TestHello.class},new TestHelloHandler(hello));

        proxy.sayHello();
    }

}
