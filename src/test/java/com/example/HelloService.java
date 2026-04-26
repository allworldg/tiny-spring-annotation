package com.example;

import com.example.annotation.Component;
import com.example.annotation.Value;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

@Component("helloservice")
public class HelloService {
    public HelloService() {

    }

    @Value("hello fke")
    private String text;

    public HelloService(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void sayFk() {
        System.out.println(text);
    }
}
