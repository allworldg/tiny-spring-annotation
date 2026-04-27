package com.example.factory;

import com.example.bean.BeanDefinition;

public interface BeanFactory {
   void registerBeanDefinition(String beanName, BeanDefinition definition);
   BeanDefinition getBeanDefinition(String beanName);

}
