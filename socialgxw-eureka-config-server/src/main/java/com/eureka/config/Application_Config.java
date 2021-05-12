package com.eureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * create by wtp
 * DATE:2021/5/4
 **/
@SpringBootApplication
@EnableConfigServer
public class Application_Config {

    public static void main(String[] args) {
        SpringApplication.run(Application_Config.class,args);
    }
}
