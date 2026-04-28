package com.example;

import com.example.annotation.Autowired;
import com.example.annotation.Component;
import com.example.annotation.Value;

@Component("helloService")
public class HelloServiceImpl implements HelloService{
    public HelloServiceImpl() {

    }

    @Value("hello fke")
    private String text;


    @Autowired
    private OutputService outputService;

    public OutputService getOutputService() {
        return outputService;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }


    public HelloServiceImpl(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void sayFk() {
        System.out.println(text);
    }
}
