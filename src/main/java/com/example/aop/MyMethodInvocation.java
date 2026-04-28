package com.example.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public class MyMethodInvocation implements MethodInvocation {
    private Object target;

    private Method method;
    private Object[] args;

    public MyMethodInvocation(Object target,Method method,Object[] args){
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target,args);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }
}
