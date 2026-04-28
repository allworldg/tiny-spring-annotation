package com.example.context;

import com.example.HelloServiceImpl;
import com.example.Main;
import com.example.bean.BeanDefinition;
import com.example.factory.AutoWireBeanFactory;
import org.junit.jupiter.api.Test;

public class AnnotationApplicationContextTest {

    @Test
    public void test() throws Exception {
        AnnotationApplicationContext context =
                new AnnotationApplicationContext(new AutoWireBeanFactory(),
                        Main.class.getPackage().getName());

        HelloServiceImpl service =(HelloServiceImpl) context.getBean("helloService");
        BeanDefinition helloService = context.getBeanDefinition("helloService");
        service.sayFk();
    }
}
