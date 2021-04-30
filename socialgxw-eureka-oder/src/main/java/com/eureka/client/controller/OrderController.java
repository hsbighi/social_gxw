package com.eureka.client.controller;

import com.eureka.client.utills.ServiceInfoUtill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.eureka.client.domain.pojo.Order;
/**
 * create by wtp
 * DATE:2021/4/29
 **/
@RestController
public class OrderController {

    private Order order ;

    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable String id){

        order = new Order();
        order.setId("123");
        order.setPrice(22.3);
        order.setReceiverAddress("安徽");
        order.setReceiverName("小王");
        order.setReceiverPhone("13302256487");

        System.out.println("端口号："+ServiceInfoUtill.getPort());
        return null ;

    }


}
