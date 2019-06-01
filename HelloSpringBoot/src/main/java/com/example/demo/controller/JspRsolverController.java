package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: ideaWorkspace
 * @description: Jsp请求拦截控制器
 * @author: wang.yubin
 * @create: 2019/06/01
 */
@Controller
public class JspRsolverController {

    /**
     * 暂时废弃这个想法，因为做不到
     * 难点在于，如何将.jsp为后缀的请求先转发到控制器这边，而不是默认的Jsp解析器
     */
    @RequestMapping("/a.jsp")
    public String toJsp(){
        System.out.println("toJsp");
        return "index";
    }

}
