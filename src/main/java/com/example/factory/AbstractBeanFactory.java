package com.example.factory;

import com.example.bean.BeanDefinition;
import com.example.bean.PropertyValue;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {
    // <beanName,value>
    private final Map<String, BeanDefinition> map = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition definition) {
        try {
            Object bean = createBean(definition);
            definition.setBean(bean);
            map.put(beanName, definition);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return map.get(beanName);
    }

    public abstract Object createBean(BeanDefinition beanDefinition) throws Exception;
}
