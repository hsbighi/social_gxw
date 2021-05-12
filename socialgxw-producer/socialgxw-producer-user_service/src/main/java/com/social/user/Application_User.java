package com.social.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * create by wtp
 * DATE:2021/5/5
 **/
@SpringBootApplication
@EnableEurekaClient
public class Application_User {

    public static void main(String[] args) {
        SpringApplication.run(Application_User.class,args);
    }


}