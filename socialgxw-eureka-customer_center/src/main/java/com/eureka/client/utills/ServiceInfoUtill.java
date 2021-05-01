package com.eureka.client.utills;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * create by wtp
 * DATE:2021/4/29
 * 服务监听类
 **/
@Configuration //注册监听组件
public class ServiceInfoUtill implements ApplicationListener<WebServerInitializedEvent> {

    /*
    * 声明 event 对象 该对象用于获取运行服务器的本地端口
    * */

    //spirng-boot 2.0 之后将
    //
    //org.springframework.boot.context.
    //embedded.EmbeddedServletContainerInitializedEvent
    //改为org.springframework.boot.web.context.WebServerInitializedEvent
    private static WebServerInitializedEvent event;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event){
        ServiceInfoUtill.event = event ;
    }

    /*
    * 获取端口号
    * */
    public static int getPort(){
        int port  = event.getWebServer().getPort() ;
        return port ;

    }


}
