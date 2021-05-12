package com.social.user.service.serviceImpl.serviceImpl;

import com.social.user.mapper.UpdateUserRepository;
import com.social.user.service.serviceImpl.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by wtp
 * DATE:2021/5/10
 **/
@Service
public class UpdateUserServiceImpl implements UpdateUserService {


    @Autowired
    UpdateUserRepository  updateUserRepository ;

    //修改头像
    public int UpdateHeadURL(String userId,String headUrl){return updateUserRepository.UpdateHeadURL(userId,headUrl); }

    //修改用户昵称
    public int UpdateNickName(String userId){
        return updateUserRepository.UpdateNickName(userId);
    }

    //修改用户签名
    public int UpdateOutoGrap(String userId){
        return updateUserRepository.UpdateOutoGrap(userId);
    }

    //修改用户性别
    public int UpdateGender(String userId){
        return updateUserRepository.UpdateGender(userId);
    }

    //修改用户生日
    public int UpdateBirthday(String userId){
        return updateUserRepository.UpdateBirthday(userId);
    }

}
