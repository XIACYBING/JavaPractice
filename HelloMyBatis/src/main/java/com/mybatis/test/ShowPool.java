package com.mybatis.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: ideaWorkspace
 * @description: 测试Tomcat数据库连接池
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public class ShowPool {

    public static void main(String[] args) throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/tomcatPool");
        Connection connection = dataSource.getConnection();
        String sql = "select * from proticable";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getLong(0));
        }
    }

}
