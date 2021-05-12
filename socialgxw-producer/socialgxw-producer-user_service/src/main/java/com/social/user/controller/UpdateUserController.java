package com.social.user.controller;

import cn.hutool.log.StaticLog;
import com.social.user.entity.Tb_UserSession;
import com.social.user.mapper.UserSessionRepository;
import com.social.user.service.serviceImpl.UpdateUserService;
import com.social.user.utills.CheckSession;
import com.social.user.utills.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * create by wtp
 * DATE:2021/5/10
 * 修改用户基本数据
 **/
@RestController
@RequestMapping(value = "update")
public class UpdateUserController {

    @Autowired
    UpdateUserService updateUserService;

    @Autowired
    UserSessionRepository userSessionRepository;

    //修改用户头像
    @RequestMapping(value = "/headURL")
    public String UpdateHeadURL(String userId,String sessionId, @RequestParam("file") MultipartFile headPicfile){

            StaticLog.info("========>>>>>修改头像");
            if(sessionId.isEmpty()){return "error";}
            UploadFile uploadFile = new UploadFile();
            CheckSession checkSession = new CheckSession();
            //验证session时效性  验证sessionID
            boolean sessionFlag = checkSession.CheckSession(sessionId);
            if(sessionFlag){
                //session有效   验证数据
                if(!userId.isEmpty() && !headPicfile.isEmpty()){

                    String fileName = headPicfile.getOriginalFilename();
                    File upload = uploadFile.getFileDir(userId);
                    File dest = new File(upload,fileName);

                    try {

                        headPicfile.transferTo(dest);
                        StaticLog.info("上传成功");
                        System.out.println(userId+"/images/"+fileName);
                        int result = updateUserService.UpdateHeadURL(userId,userId+"/images/"+fileName);
                        //修改数据
                        StaticLog.info("updateHead.result====>>>>"+result);
                        //返回新数据至客户端
                        return "";
                    } catch ( IOException e) {
                        StaticLog.error(e.toString(), e);
                    }
                    }
                else{return "uploadFile is false 101";}
                     return "uploadFile is false 102";}
                     return "uploadFile is false 103";


    }




}
