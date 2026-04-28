package com.example.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;

    public JdkDynamicAopProxy(TargetSource targetSource, MethodInterceptor methodInterceptor){
        this.targetSource = targetSource;
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{targetSource.getTargetClass()}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return methodInterceptor.invoke(new MyMethodInvocation(targetSource.getTarget(),method,args));
    }
}
