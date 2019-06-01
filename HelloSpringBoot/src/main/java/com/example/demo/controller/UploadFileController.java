package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: ideaWorkspace
 * @description: 测试Spring MVC的文件上传功能
 * @author: wang.yubin
 * @create: 2019/05/31
 */
@Controller
public class UploadFileController {

    private static Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(MultipartFile file){
        StringBuffer path = new StringBuffer("F:/");
        path.append(file.getOriginalFilename());
        try {
            file.transferTo(new File(path.toString()));
        } catch (IOException e) {
            logger.error("文件上传错误，原因：{}",e);
        }
        return "success";
    }

    @RequestMapping(value = "/uploadFiles",method = RequestMethod.POST)
    public String uploadFiles(MultipartFile[] files){
        /**确保本地目录存在*/
        StringBuffer path = new StringBuffer("F:/uploadFiles/");
        for(MultipartFile mFile : files){
            try{
                mFile.transferTo(new File(path.toString() + mFile.getOriginalFilename()));
            } catch (IOException | IllegalStateException e) {
                logger.error("多个文件上传错误，原因：{}",e.getMessage());
            }
        }
        return "success";
    }

}
