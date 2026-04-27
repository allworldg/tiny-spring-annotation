package com.example.context;

import com.example.HelloService;
import com.example.Main;
import com.example.bean.BeanDefinition;
import com.example.factory.AutoWireBeanFactory;
import org.junit.jupiter.api.Test;
import sun.reflect.annotation.AnnotatedTypeFactory;

public class AnnotationApplicationContextTest {

    @Test
    public void test() throws Exception {
        AnnotationApplicationContext context =
                new AnnotationApplicationContext(new AutoWireBeanFactory(),
                        Main.class.getPackage().getName());

        HelloService service =(HelloService) context.getBean("helloService");
        BeanDefinition helloService = context.getBeanDefinition("helloService");
        service.sayFk();
    }
}
