package com.example;

import com.example.bean.BeanDefinition;
import com.example.factory.AutoWireBeanFactory;
import com.example.factory.BeanFactory;
import com.sun.corba.se.impl.protocol.FullServantCacheLocalCRDImpl;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

import java.util.Map;

public class BeandifinitionTest {
    @Test
    void test() throws Exception {
        BeanFactory factory = new AutoWireBeanFactory();
        AnnotationBeanDefinitionReader reader = new AnnotationBeanDefinitionReader();
        reader.loadBeanDefinition(Main.class.getPackage().getName());

        for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()){
            factory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }

        HelloService helloservice =
                (HelloService) factory.getBeanDefinition("helloservice").getBean();
        helloservice.sayFk();

    }
}
