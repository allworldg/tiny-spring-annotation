package com.example.factory;

import com.example.bean.BeanDefinition;
import com.example.bean.BeanReference;
import com.example.bean.PropertyValue;

import java.lang.reflect.Field;
import java.util.Map;

public class AutoWireBeanFactory extends AbstractBeanFactory {
    public Object createBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = Class.forName(beanDefinition.getClassName()).newInstance();
        beanDefinition.setValue(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    public void applyPropertyValues(Object bean, BeanDefinition definition) throws Exception {
        for (PropertyValue property : definition.getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(property.getName());
            declaredField.setAccessible(true);
            Object value = property.getValue();
            if(value instanceof BeanReference){
                value = getBean(property.getName());
            }
            declaredField.set(bean, value);
        }
    }


}
