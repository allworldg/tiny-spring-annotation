package com.example;

import com.example.annotation.Autowired;
import com.example.annotation.Component;
import com.example.annotation.Value;
import com.example.bean.BeanDefinition;
import com.example.bean.BeanReference;
import com.example.bean.PropertyValue;
import com.example.util.ClassScanner;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationBeanDefinitionReader implements BeanDefinitionReader {
    private final Map<String, BeanDefinition> registry = new HashMap();
    private final ClassScanner scanner = new ClassScanner();

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }


    @Override
    public void loadBeanDefinition(String basePackageName) throws Exception {
        List<String> classNameList = scanner.doScan(Main.class.getPackage().getName());
        for (String className : classNameList) {
            Class<?> beanClass = Class.forName(className);
            if (beanClass.isAnnotationPresent(Component.class)) {
                BeanDefinition beanDefinition = createBeanDefinition(beanClass);
                Component annotation = beanClass.getAnnotation(Component.class);
                String beanName =
                        annotation.value().isEmpty() ? beanClass.getSimpleName() : annotation.value();
                registry.put(beanName, beanDefinition);
            }
        }
    }

    public BeanDefinition createBeanDefinition(Class beanClass) {
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(beanClass.getName());
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            PropertyValue propertyValue = new PropertyValue();
            if (field.isAnnotationPresent(Value.class)) {
                Value annotation = field.getAnnotation(Value.class);
                String fieldName = field.getName();
                String fieldValue = annotation.value();
                propertyValue.setName(fieldName);
                propertyValue.setValue(fieldValue);
            }else if(field.isAnnotationPresent(Autowired.class)){
                String fieldName = field.getName();
                BeanReference reference = new BeanReference();
                reference.setName(fieldName);
                propertyValue.setName(fieldName);
                propertyValue.setValue(reference);
            }
            if (!propertyValue.getName().isEmpty()){
                beanDefinition.getPropertyValues().add(propertyValue);
            }

        }
        return beanDefinition;

    }
}
