package com.example;

import com.example.bean.BeanDefinition;
import com.example.factory.AbstractBeanFactory;
import com.example.factory.AutoWireBeanFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BeandifinitionTest {
    @Test
    void test() throws Exception {
        AbstractBeanFactory factory = new AutoWireBeanFactory();
        AnnotationBeanDefinitionReader reader = new AnnotationBeanDefinitionReader();
        reader.loadBeanDefinition(Main.class.getPackage().getName());

        for(Map.Entry<String,BeanDefinition> entry:reader.getRegistry().entrySet()){
            factory.getBeanDefinitionMap().put(entry.getKey(),entry.getValue());
        }

        factory.initialBeans();

        HelloServiceImpl service = (HelloServiceImpl) factory.getBeanDefinition("helloService").getValue();
        service.sayFk();



    }
}
