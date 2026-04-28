package com.example.testHandler;

import org.junit.jupiter.api.Tag;

import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestHelloHandler implements InvocationHandler {
    private Object target;
    public TestHelloHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("yes I intercept this, I want to say fku");
        return method.invoke(target,args);
    }
}
