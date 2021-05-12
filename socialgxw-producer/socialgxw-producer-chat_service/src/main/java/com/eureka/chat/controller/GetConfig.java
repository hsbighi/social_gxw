package com.eureka.chat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by wtp
 * DATE:2021/5/4
 **/
@RestController
@RefreshScope
public class GetConfig {

    @Value("${config.info}")
    private String clientParam ;
    @GetMapping(value = "getconf")
    public String getConfig(){

        return clientParam;
    }
}
