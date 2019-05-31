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

    @RequestMapping(value = "/upload")
    public String uploadFiel(MultipartFile file){
        StringBuffer path = new StringBuffer("F:/");
        path.append(file.getOriginalFilename());
        try {
            file.transferTo(new File(path.toString()));
        } catch (IOException e) {
            logger.error("文件上传错误，原因：{}",e);
        }
        return "success";
    }

}
