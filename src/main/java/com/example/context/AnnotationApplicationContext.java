package com.example.context;

import com.example.AnnotationBeanDefinitionReader;
import com.example.bean.BeanDefinition;
import com.example.factory.AbstractBeanFactory;
import com.sun.xml.internal.bind.v2.model.annotation.AnnotationReader;

import java.util.Map;

public class AnnotationApplicationContext extends AbstractApplicationContext {
    private String basePackageName;
    public AnnotationApplicationContext(AbstractBeanFactory factory,String basePackageName) throws Exception {
        super(factory);
        this.basePackageName = basePackageName;
        initContext();
    }

    @Override
    public void initContext() throws Exception {
        AnnotationBeanDefinitionReader reader = new AnnotationBeanDefinitionReader();
        reader.loadBeanDefinition(basePackageName);
        for(Map.Entry<String,BeanDefinition> entry:reader.getRegistry().entrySet()){
            factory.getBeanDefinitionMap().put(entry.getKey(),entry.getValue());
        }
    }
}
