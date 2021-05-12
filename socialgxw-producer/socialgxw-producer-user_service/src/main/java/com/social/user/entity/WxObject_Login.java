package com.social.user.entity;

import lombok.Data;

/**
 * create by wtp
 * DATE:2021/5/8
 **/

public class WxObject_Login {

    private String openid ;     //用户唯一标识
    private String session_key ; //会话密钥
    private String Uniq ; //用户在开放平台的唯一标识符
    private String ErrCode ; //错误码
    private String ErrMsg ; //错误信息

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUniq() {
        return Uniq;
    }

    public void setUniq(String uniq) {
        Uniq = uniq;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String errCode) {
        ErrCode = errCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }
}
