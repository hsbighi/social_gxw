package com.eureka.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * create by wtp
 * DATE:2021/4/30
 **/
@SpringBootApplication
@EnableHystrixDashboard//开启断路器监控
public class Application_dashboard {

    public static void main(String[] args) {
        SpringApplication.run(Application_dashboard.class,args);
    }

}
