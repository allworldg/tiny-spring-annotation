package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    public BeanDefinition(){}
    private Object bean;
    private String className;

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
