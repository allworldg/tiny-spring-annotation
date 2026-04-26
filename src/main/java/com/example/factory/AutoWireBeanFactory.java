package com.example.factory;

import com.example.bean.BeanDefinition;
import com.example.bean.PropertyValue;

import java.lang.reflect.Field;

public class AutoWireBeanFactory extends AbstractBeanFactory {
    @Override
    public Object createBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = Class.forName(beanDefinition.getClassName()).newInstance();
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    public void applyPropertyValues(Object bean, BeanDefinition definition) throws Exception {
        for (PropertyValue property : definition.getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(property.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, property.getValue());
        }
    }

}
