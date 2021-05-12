package com.social.user.mapper;

import com.social.user.entity.Tb_UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by wtp
 * DATE:2021/5/10
 **/
@Repository
public interface UpdateUserRepository extends JpaRepository<Tb_UserInfo,Integer> {

    //修改头像
    @Transactional
    @Query(value = "update Tb_UserInfo u set u.user_pic_adr=?1 where u.id=?2")
    int UpdateHeadURL(String userId,String headUrl);

    //修改用户昵称
    @Transactional
    @Query(value = "update Tb_UserInfo u set u.user_nickname=?1 where u.id=?2")
    int UpdateNickName(String userId);

    //修改用户签名
    @Transactional
    @Query(value = "update Tb_UserInfo u set u.user_autograph=?1 where u.id=?2")
    int UpdateOutoGrap(String userId);

    //修改用户性别
    @Transactional
    @Query(value = "update Tb_UserInfo u set u.gender=?1 where u.id=?2")
    int UpdateGender(String userId);

    //修改用户生日
    @Transactional
    @Query(value = "update Tb_UserInfo u set u.birthday=?1 where u.id=?2")
    int UpdateBirthday(String userId);


}
