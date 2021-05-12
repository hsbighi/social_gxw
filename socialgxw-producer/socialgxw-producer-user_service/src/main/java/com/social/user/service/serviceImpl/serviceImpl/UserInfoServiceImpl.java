package com.social.user.service.serviceImpl.serviceImpl;

import com.social.user.entity.Tb_UserInfo;
import com.social.user.mapper.UserRepository;
import com.social.user.service.serviceImpl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create by wtp
 * DATE:2021/5/5
 **/
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserRepository userRepository;


    public List<Tb_UserInfo> findByUserId(int id){
        return userRepository.findByUserId(id);
    }

    public Object[] findAllByUserNameLike(String username){
        return userRepository.findAllByUserNameLike(username);
    }
}
