package com.example.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("consumer-service")
public interface ConsumerServicer {

    @RequestMapping("/consumerTest")
    String consumerTest();

}
