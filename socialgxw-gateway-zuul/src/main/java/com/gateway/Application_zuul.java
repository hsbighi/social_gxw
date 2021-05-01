package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * create by wtp
 * DATE:2021/4/30
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy  //开启网关功能
public class Application_zuul {

    public static void main(String[] args) {
        SpringApplication.run(Application_zuul.class,args);
    }
}
