package com.example.factory;

import com.example.bean.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {
    public Map<String, BeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    // <beanName,value>
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition definition) {
        beanDefinitionMap.put(beanName, definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    public void initialBeans() throws Exception {
        for (Map.Entry<String, BeanDefinition> entry : getBeanDefinitionMap().entrySet()) {
            String beanName = entry.getKey();
            getBean(beanName);
        }
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        Object bean = beanDefinition.getValue();
        if(beanDefinition==null){
            throw new IllegalArgumentException(beanName+" is not defined");
        }
        if(bean==null){
            bean = createBean(beanDefinition);
        }
        return bean;
    }


    public abstract Object createBean(BeanDefinition beanDefinition) throws Exception;

}
