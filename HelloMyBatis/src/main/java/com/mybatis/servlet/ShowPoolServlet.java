package com.mybatis.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        Context context;
        DataSource dataSource;
        Connection connection;
        PreparedStatement ps;
        ResultSet rs;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/tomcatPool");
            connection = dataSource.getConnection();
            String sql = "select * from proticable";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getLong(0));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
