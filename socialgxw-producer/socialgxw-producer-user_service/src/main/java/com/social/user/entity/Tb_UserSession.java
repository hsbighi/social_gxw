package com.social.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * create by wtp
 * DATE:2021/5/8
 **/
@Data
@Entity
@Table(name = "tb_user_session")
public class Tb_UserSession {

    @Id
    private int id;


    @Column(name="sessionid",unique = true,nullable = false)
    private String sessionid;


    @Column(name="openid",nullable = false)
    private String openid;


    @Column(name="session_key",nullable = false)
    private String session_key;


    @Column(name="valid_time",nullable = false)
    private String valid_time;

    @Column(name="unionid",nullable = false)
    private String unionid;

}
