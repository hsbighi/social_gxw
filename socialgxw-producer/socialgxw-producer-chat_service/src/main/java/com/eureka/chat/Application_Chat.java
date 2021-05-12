package com.eureka.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by wtp
 * DATE:2021/5/4
 **/
@SpringBootApplication
@EnableEurekaClient
public class Application_Chat {

    public static void main(String[] args) {
        SpringApplication.run(Application_Chat.class,args);
    }
}
