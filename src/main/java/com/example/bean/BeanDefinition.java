package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    public BeanDefinition(){}
    private Object value;
    private String className;

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
