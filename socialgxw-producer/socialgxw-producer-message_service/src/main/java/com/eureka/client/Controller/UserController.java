package com.eureka.client.Controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * create by wtp
 * DATE:2021/4/29
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate ;

    @GetMapping("/findOrderByUser/{id}")
    //@HystrixCommand 指定当前方法发生异常时调用的回调方法
    //通过fallbackMethod 指定
    //回调方法的参数及返回值必须和原方法一致
    @HystrixCommand(fallbackMethod = "fallbackInfo")
    public String findOrderByUser(@PathVariable String id){

        int OrderId = 123;
        return this.restTemplate.getForObject("http://order/order/"+id,String.class) ;

    }

    public String fallbackInfo(@PathVariable String id){
        return "服务不可用，请稍后再试！";
    }


}
