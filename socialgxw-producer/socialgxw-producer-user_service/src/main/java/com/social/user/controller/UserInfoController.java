package com.social.user.controller;

import com.social.user.entity.Tb_UserInfo;
import com.social.user.service.serviceImpl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by wtp
 * DATE:2021/5/5
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getByName")
    @Transactional
    //test 查询基本信息
    public Object[] getUserByName(@PathVariable(value = "username") String username){

        //System.out.println("--------user---------");
        return userInfoService.findAllByUserNameLike(username);

    }

    @GetMapping("/getUser")
    @Transactional
    //查看
    public List<Tb_UserInfo> getUser(){

        return userInfoService.findByUserId(1);

    }

}
