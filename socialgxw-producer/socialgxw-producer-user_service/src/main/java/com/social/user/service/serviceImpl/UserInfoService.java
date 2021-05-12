package com.social.user.service.serviceImpl;

import com.social.user.entity.Tb_UserInfo;

import java.util.List;

/**
 * create by wtp
 * DATE:2021/5/5
 **/
public interface UserInfoService {

    public List<Tb_UserInfo> findByUserId(int id);

    public Object[] findAllByUserNameLike(String username);
}
