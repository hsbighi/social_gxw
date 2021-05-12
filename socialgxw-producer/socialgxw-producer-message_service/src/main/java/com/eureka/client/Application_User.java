package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * create by wtp
 * DATE:2021/4/28
 * 启动类
 **/
@SpringBootApplication
@EnableDiscoveryClient   //消息注册 客户端 消息接受者
@EnableHystrix //开启断容器功能
public class Application_User {


    public static void main(String[] args) {

        SpringApplication.run(Application_User.class,args);
    }

    //创建RestTemplate
    //RestTemplate 是 spring提供的用于访问Rest服务的客户端
    //提供远程http
    @Bean
    @LoadBalanced //使用Ribbon 使用负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
