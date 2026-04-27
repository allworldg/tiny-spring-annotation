package com.example.factory;

import com.example.bean.BeanDefinition;

public interface BeanFactory {
   BeanDefinition getBeanDefinition(String beanName);

   Object getBean(String beanName) throws Exception;

}
