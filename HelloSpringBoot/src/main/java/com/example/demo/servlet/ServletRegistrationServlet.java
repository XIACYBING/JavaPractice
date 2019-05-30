package com.example.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @program: HelloSpringBoot
 * @description:
 * @author: wang.yubin
 * @create: 2019/05/27
 */
public class ServletRegistrationServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        res.getWriter().write("ServletRegistrationServlet");
    }
}
