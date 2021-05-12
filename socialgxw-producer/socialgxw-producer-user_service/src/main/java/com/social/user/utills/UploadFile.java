package com.social.user.utills;

import com.social.user.entity.WXConstant;

import java.io.File;

/**
 * create by wtp
 * DATE:2021/5/11
 * 上传文件
 **/
public class UploadFile {


        public static File getFileDir(String userId) {



            //如果上传目录为/static/images/upload/,则可以如下获取
            File upload=new File(WXConstant.filePath,userId+WXConstant.childPath);
            if(!upload.exists()){
                upload.mkdirs();
                //在开发测试模式时，得到地址为：{项目跟目录}/target/static/images/upload/
                //在打成jar正式发布时，得到的地址为:{发布jar包目录}/static/images/upload/

            }
            System.out.println(upload.getAbsolutePath());

            return upload;
        }


}
