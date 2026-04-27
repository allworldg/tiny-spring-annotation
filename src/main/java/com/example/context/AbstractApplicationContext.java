package com.example.context;

import com.example.bean.BeanDefinition;
import com.example.factory.AbstractBeanFactory;
import com.example.factory.BeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext{
    protected AbstractBeanFactory factory;
    public AbstractApplicationContext(AbstractBeanFactory factory){
        this.factory = factory;
    }

    public abstract void initContext() throws Exception;


    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return factory.getBeanDefinition(beanName);
    }

    public Object getBean(String beanName) throws Exception {
       return factory.getBean(beanName);
    }

}
