package com.mybatis.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @program: ideaWorkspace
 * @description: 测试Tomcat数据库连接池
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public class ShowPoolServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("doService");
    }
}
