package com.social.user.mapper;

import com.social.user.entity.Tb_UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create by wtp
 * DATE:2021/5/8
 **/
@Repository
public interface WxUserRepository extends JpaRepository<Tb_UserInfo,Integer> {

    //自定义方法 使用JPA标准化查询语句
    @Query(value = "from Tb_UserInfo")
    List<Tb_UserInfo> findByUserId(int id);

    //使用JPQL查询 注意JPQL返回的是OBJECT[]类型
    @Query(value = "select u.id,u.user_nickname,u.user_tel from Tb_UserInfo u where u.user_nickname like "+"%?1%")
    Object[] findAllByUserNameLike(String username);

    //通过sessionID查找用户信息
    Tb_UserInfo findBySessionId(String sessionId);

    //添加用户信息
    //Tb_UserInfo Save

}
