package com.social.user.service.serviceImpl.serviceImpl;

import cn.hutool.log.StaticLog;
import com.social.user.entity.Tb_UserSession;
import com.social.user.mapper.UserSessionRepository;
import com.social.user.service.serviceImpl.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by wtp
 * DATE:2021/5/8
 **/
@Service
public class UserSessionImpl implements UserSessionService {

    @Autowired
    UserSessionRepository sessionRepository;
    //添加Session信息
    public void addSession(Tb_UserSession userSession){sessionRepository.save(userSession);}

    //检测Session有效性
    public Tb_UserSession getSession(String SessionId){return sessionRepository.findBySessionid(SessionId);}

    //查询用户是否已经注册
    public Tb_UserSession existence(String openId){   return sessionRepository.findByOpenid(openId);}

    //更新登录状态
    public void UpdateUserSession(Tb_UserSession userSession){
        int i = sessionRepository.UpdateUserSession(userSession.getOpenid(),userSession.getSession_key(),userSession.getSessionid(),userSession.getValid_time(),userSession.getId());
        StaticLog.info(i+"");}
}
