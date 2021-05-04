package com.eureka.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * create by wtp
 * DATE:2021/5/4
 **/
@RestController
public class testController {

    @Autowired
    private RestTemplate restTemplate ;

    @GetMapping("/test/{id}")
    @HystrixCommand(fallbackMethod = "fallbackInfo")
    public String findOrderByUser(@PathVariable String id){

        int OrderId = 123;
        return this.restTemplate.getForObject("http://order/order/"+id,String.class) ;

    }

    public String fallbackInfo(@PathVariable String id){
        return "服务不可用，请稍后再试！";
    }

}
