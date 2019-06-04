package com.mybatis.controller;

import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: ideaWorkspace
 * @description: 展示用户的测试类
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public class ShowUser {

    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sessionFactory.openSession();
        /*List<User> list = session.selectList("com.mybatis.mapper.UserMapper.selAll");*/
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.selAll();
        for(User user:list){
            System.out.println(user.toString());
        }
        session.close();
    }

}
