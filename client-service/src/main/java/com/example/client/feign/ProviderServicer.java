package com.example.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider-service")
public interface ProviderServicer {

    @RequestMapping("/providerTest")
    String providerTest();
}
