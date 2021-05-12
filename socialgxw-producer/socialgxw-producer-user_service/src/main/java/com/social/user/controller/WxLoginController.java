package com.social.user.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.social.user.entity.Tb_UserInfo;
import com.social.user.entity.Tb_UserSession;
import com.social.user.entity.WXConstant;
import com.social.user.entity.WxObject_Login;
import com.social.user.service.serviceImpl.WxUserInfoService;
import com.social.user.service.serviceImpl.UserSessionService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * create by wtp
 * DATE:2021/5/7
 **/
@RestController
@RequestMapping(value = "wx")
public class WxLoginController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WxUserInfoService wxUserInfoService;

    @Autowired
    private UserSessionService userSessionService;

    //微信登录
    @GetMapping(value = "/wxlogin")
    public String wxLogin(@RequestParam(value = "code") String code,@RequestParam(value = "session") String session) {
        StaticLog.info("code: {} log.", code);
        //向微信服务器发起请求 GET
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("appid", WXConstant.APP_ID);
        paramMap.put("secret", WXConstant.APPSECRET);
        paramMap.put("js_code", code);
        paramMap.put("grant_type", WXConstant.GRANT_TYPE);
        //
        String _RESULT = HttpUtil.get(WXConstant.WX_LOGIN_URL, paramMap);
        JSONObject jsonObject = JSONUtil.parseObj(_RESULT);
        WxObject_Login wxObj = new WxObject_Login();

        StaticLog.info("result: {} ", _RESULT);
        String CODE = jsonObject.get("errcode") != null ? jsonObject.get("errcode").toString() : "null";
        String Msg = jsonObject.get("errmsg") != null ? jsonObject.get("errmsg").toString() : "null";
        String third_Session = " ";
        boolean flag = userSessionService.getSession(session)==null;
        StaticLog.info("session: {} ", session);
        StaticLog.info("flag: {} ", flag);

        if (jsonObject.get("openid") != null) {
            if ("".equals(session)) {
                //第一次注册 暂无session
                Tb_UserSession TBuserSession = userSessionService.existence(jsonObject.get("openid").toString());

                if (null == TBuserSession) {
                    //未注册 进行注册登录状态
                    third_Session = getTHSession();
                    StaticLog.info("userSession is null");
                    addSession(third_Session,jsonObject.get("openid").toString(), jsonObject.get("session_key").toString());
                } else {
                    StaticLog.info("userSession is not null");
                }
                }
            else{
                StaticLog.info("session is exit");
                //前端存在session----->更新登录状态
                UpdateUserSession(jsonObject.get("openid").toString(),jsonObject.get("session_key").toString(), session);
                }
                }
            else {
            StaticLog.info("errcode: {} ", CODE);
            StaticLog.info("errmsg: {} ", Msg);

            }
            //返回状态
            JSONObject json1 = JSONUtil.createObj().putOnce("third_Session", third_Session);
            StaticLog.info("third_Session: {} ", json1.toString());
            return third_Session != null ? json1.toString() : "no session";
    }

    //注册新用户 返回客户端JSON
    @GetMapping(value = "/wxregister")
    public String register(@RequestParam(value = "userJson") String userJson, @RequestParam(value = "session") String session) {

        String USER_JSON ="";
        try {

            if (null != userJson && "" != userJson) {
                //StaticLog.info("wxregister: {} ", userJson);
                //StaticLog.info("session: {} ", session);
                //获取用户基本信
                JSONObject jsonObject = JSONUtil.parseObj(userJson);

                if (!jsonObject.isEmpty() && getUserInfoByID(session)) {
                    //StaticLog.info("register========>>>");
                    String nickName = jsonObject.get("nickName") != null ? jsonObject.get("nickName").toString() : RandomUtil.randomString(18) + "";
                    String gender = jsonObject.get("gender") != null ? jsonObject.get("gender").toString() : "0";
                    String province = jsonObject.get("province") != null ? jsonObject.get("province").toString() : "未知";
                    String city = jsonObject.get("city") != null ? jsonObject.get("city").toString() : "未知";
                    String avatarUrl = jsonObject.get("avatarUrl") != null ? jsonObject.get("avatarUrl").toString() : " ";
                    //创建用户
                    Tb_UserInfo userInfo = new Tb_UserInfo();
                    ///////
                    userInfo.setUser_nickname(nickName);
                    userInfo.setUser_home_adr(province + city);
                    userInfo.setGender(gender);
                    userInfo.setUser_tel("暂未绑定手机");
                    userInfo.setUser_pic_adr(avatarUrl);
                    userInfo.setUser_autograph("暂时还没有签名哦~");
                    userInfo.setSessionId(session);
                    wxUserInfoService.addUserInfo(userInfo);
                    //
                    //USER_JSON = JSONUtil.createObj().putOnce("userInfo", userInfo).toString();

                    JSONObject json1 = JSONUtil.createObj().putOnce("userInfo", userInfo);
                    USER_JSON = json1.toString();
                    StaticLog.info("USER_JSON: {} ", USER_JSON);
                }
            }

        } catch (Exception e) {

            StaticLog.info("register------>>: {} ", e.getMessage());
        }

        return USER_JSON ;
    }

    //检测用户是否存在
    public boolean getUserInfoByID(String Session) {

        return null == wxUserInfoService.findUserBySession(Session);
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

    //获取userSession对象
    public Tb_UserSession getUserSessionBySessionId(String sessionId) {

        return userSessionService.getSession(sessionId);

    }

    //生成session
    public void addSession(String third_Session, String openid,String session_key){
        try {
            Tb_UserSession userSession;
            String valid_time = getDateInfo();
            Tb_UserSession tb_userSession = new Tb_UserSession();
            tb_userSession.setSessionid(third_Session);
            tb_userSession.setSession_key(session_key);
            tb_userSession.setValid_time(valid_time);
            tb_userSession.setOpenid(openid);
            tb_userSession.setUnionid("");
            //
            userSessionService.addSession(tb_userSession);
        }catch (Exception e){
            StaticLog.error("Session------>>>"+e.getMessage());
        }

    }

    //更新用户登录状态
    public void UpdateUserSession(String openId,String key,String SessionId){

        try {
            int ID = 0;
            if(null != getUserSessionBySessionId(SessionId)){
            ID = getUserSessionBySessionId(SessionId).getId();
            StaticLog.info("id=====>>>{}",ID);
            Tb_UserSession session_new = new Tb_UserSession();
            session_new.setId(ID);
            session_new.setOpenid(openId);
            session_new.setSession_key(key);
            session_new.setSessionid(getTHSession());
            userSessionService.UpdateUserSession(session_new);
        }
        else {
            StaticLog.error("UpdateUserSession=======>>>error:暂无此sessionId的记录！");
        }
        }catch (Exception e){
            StaticLog.error("UpdateUserSession=======>>>error:{}",e.getMessage());
        }


    }

    //获取有效时间
    public String getDateInfo(){
        Date data = DateUtil.date(Calendar.getInstance());
        Date date = DateUtil.offset(data, DateField.DAY_OF_MONTH, 2);
        return DateUtil.formatDate(date);
    }

    //获取th_sessionId
    public String getTHSession(){
       return RandomUtil.randomString(16) + RandomUtil.randomString(10);
    }

}
