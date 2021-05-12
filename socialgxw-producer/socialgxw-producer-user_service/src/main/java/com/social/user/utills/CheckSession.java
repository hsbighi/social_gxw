package com.social.user.utills;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.log.StaticLog;
import com.social.user.entity.Tb_UserSession;
import com.social.user.mapper.UserSessionRepository;
import com.social.user.service.serviceImpl.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

/**
 * create by wtp
 * DATE:2021/5/9
 **/
public class CheckSession {

    @Autowired
    UserSessionService userSessionService;


    public static void main(String[] args) {
//        String dateStr1 = "2017-04-01";
//        Date date1 = DateUtil.parse(dateStr1);
//
//        String dateStr2 = "2017-04-02";
//        Date date2 = DateUtil.parse(dateStr2);
//
//        //相差一个月，31天
//        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
//        //StaticLog.info("time:"+betweenDay);
    }


    //检测Session时效性
    public boolean CheckSession(String session) {

        Tb_UserSession userSession = userSessionService.getSession(session);
        if (null == userSession) {
            return false;
        } else {
            String time = userSession.getValid_time();
            StaticLog.info("Session时效性检测: {} ", time);
            Date sessionDate = DateUtil.parse(time);
            Date nowDate = DateUtil.date(Calendar.getInstance());
            return sessionDate.before(nowDate) || sessionDate.equals(nowDate);
        }


    }

}
