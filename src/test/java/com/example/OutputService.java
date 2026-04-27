package com.example;

import com.example.annotation.Autowired;
import com.example.annotation.Component;

@Component("outputService")
public class OutputService {
    public OutputService() {
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }


    @Autowired
    private HelloService helloService;

}
