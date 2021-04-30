package com.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * create by wtp
 * DATE:2021/4/28
 * 注册中心类 启动类
 **/
@SpringBootApplication
@EnableEurekaServer
public class Application_server {
    public static void main(String[] args) {
        SpringApplication.run(Application_server.class,args);
    }
}
