package com.example.aop;

public class TargetSource {

    public TargetSource(){}
    public TargetSource(Object target,Class targetClass){
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    private Object target;
    private Class targetClass;
}
