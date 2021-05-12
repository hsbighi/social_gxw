package com.social.user.service.serviceImpl;

import com.social.user.entity.Tb_UserInfo;
import com.social.user.entity.Tb_UserSession;

/**
 * create by wtp
 * DATE:2021/5/7
 * 微信登录相关操作
 **/
public interface WxUserInfoService {


    //添加基本用户信息
     void addUserInfo(Tb_UserInfo userInfo);

     //检测用户是否注册
     Tb_UserInfo findUserBySession(String Seesion);

}
