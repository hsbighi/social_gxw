package com.social.user.mapper;

import com.social.user.entity.Tb_UserInfo;
import com.social.user.entity.Tb_UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by wtp
 * DATE:2021/5/8
 **/
@Repository
public interface UserSessionRepository extends JpaRepository<Tb_UserSession,Integer> {


      Tb_UserSession findByOpenid(String openid);


      Tb_UserSession findBySessionid(String Session);


      @Transactional
      @Modifying // QueryExecutionRequestException: Not supported for DML operations
      @Query("update Tb_UserSession s set s.openid =?1,s.session_key=?2,s.sessionid=?3,s.valid_time=?4  where s.id=?5")
      int UpdateUserSession(String openId,String session_key,String session,String time,int ID);
}
