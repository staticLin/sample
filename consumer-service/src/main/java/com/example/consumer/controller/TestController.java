package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/consumerTest")
    public String consumerTest(){
        return "consumerTest";
    }
}
