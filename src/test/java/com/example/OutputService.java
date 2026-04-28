package com.example;

import com.example.annotation.Autowired;
import com.example.annotation.Component;

@Component("outputService")
public class OutputService {
    public OutputService() {
    }

    public HelloServiceImpl getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloServiceImpl helloService) {
        this.helloService = helloService;
    }


    @Autowired
    private HelloServiceImpl helloService;

}
