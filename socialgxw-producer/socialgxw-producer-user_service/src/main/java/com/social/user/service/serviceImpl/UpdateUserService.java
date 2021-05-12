package com.social.user.service.serviceImpl;

/**
 * create by wtp
 * DATE:2021/5/10
 **/
public interface UpdateUserService {

    //修改头像
    int UpdateHeadURL(String userId,String headUrl);

    //修改用户昵称
    int UpdateNickName(String userId);

    //修改用户签名
    int UpdateOutoGrap(String userId);

    //修改用户性别
    int UpdateGender(String userId);

    //修改用户生日
    int UpdateBirthday(String userId);
}
