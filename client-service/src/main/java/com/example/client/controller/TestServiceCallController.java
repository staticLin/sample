package com.example.client.controller;

import com.example.client.feign.ConsumerServicer;
import com.example.client.feign.ProviderServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test the method
 */
@RestController
public class TestServiceCallController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProviderServicer providerServicer;
    @Autowired
    private ConsumerServicer consumerServicer;

    /**
     * run this method twice at least
     */
    @RequestMapping("/test")
    public void test(){

        ServiceInstance consumer = loadBalancerClient.choose("consumer-service");
        ServiceInstance provider = loadBalancerClient.choose("provider-service");

        //this will print same uri in second time
        System.out.println(consumer.getUri());
        System.out.println(provider.getUri());
    }

    /**
     * run this method twice at least
     */
    @RequestMapping("/testFeign")
    public void testFeign(){

        //this will throw exception(404) in second time
        providerServicer.providerTest();
        consumerServicer.consumerTest();
    }

}
