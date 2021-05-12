package com.social.user.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * create by wtp
 * DATE:2021/5/5
 **/
@Entity
@Table(name = "tb_user_info")
@Data
public class Tb_UserInfo {

    @Id
    private int id;


    @Column(name="user_nickname",unique = true,nullable = false)
    private String user_nickname;


    @Column(name="user_tel",nullable = false)
    private String user_tel;


    @Column(name="user_autograph",nullable = false)
    private String user_autograph;



    @Column(name="user_home_adr",nullable = false)
    private String user_home_adr;


    @Column(name="user_pic_adr",nullable = false)
    private String user_pic_adr;


    @Column(name="gender",nullable = false)
    private String gender;


    @Column(name="th_session",nullable = false)
    private String sessionId;

    @Column(name="user_birthday",nullable = false)
    private String birthday;

}
