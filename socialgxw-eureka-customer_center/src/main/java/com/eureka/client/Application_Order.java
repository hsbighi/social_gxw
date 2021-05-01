package com.eureka.client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by wtp
 * DATE:2021/4/29
 **/
@SpringBootApplication
@EnableEurekaClient
public class Application_Order {

    public static void main(String[] args) {

        SpringApplication.run(Application_Order.class,args);
    }
}
