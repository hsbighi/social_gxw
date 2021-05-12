package com.social.user.service.serviceImpl.serviceImpl;

import cn.hutool.log.StaticLog;
import com.social.user.entity.Tb_UserInfo;
import com.social.user.entity.Tb_UserSession;
import com.social.user.mapper.UserRepository;
import com.social.user.mapper.UserSessionRepository;
import com.social.user.mapper.WxUserRepository;
import com.social.user.service.serviceImpl.WxUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by wtp
 * DATE:2021/5/8
 **/
@Service
public class WxUserInfoServiceImpl implements WxUserInfoService {


    @Autowired
    WxUserRepository wxUserRepository;

    //添加基本用户信息
    @Transactional
    public void addUserInfo(Tb_UserInfo userInfo){wxUserRepository.save(userInfo);}

    //检测用户是否注册
    public  Tb_UserInfo findUserBySession(String Seesion){return wxUserRepository.findBySessionId(Seesion);}


}
