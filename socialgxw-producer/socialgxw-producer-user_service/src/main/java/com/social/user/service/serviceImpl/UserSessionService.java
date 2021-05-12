package com.social.user.service.serviceImpl;

import com.social.user.entity.Tb_UserSession;

/**
 * create by wtp
 * DATE:2021/5/8
 **/
public interface UserSessionService {

    //添加基本Session
    public void addSession(Tb_UserSession userSession);

    //检测Session有效性
    Tb_UserSession getSession(String SessionId);

    //查询用户是否已经注册
    Tb_UserSession existence(String id);

    //更新登录状态
    void UpdateUserSession(Tb_UserSession userSession);
}
