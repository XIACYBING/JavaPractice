package com.mybatis.test;

import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ideaWorkspace
 * @description: 展示用户的测试类
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public class ShowUser {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(ShowUser.class);
        InputStream in = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sessionFactory.openSession();

        /**直接调用Mapper.xml进行selectList查询*/
        List<User> list0 = session.selectList("com.mybatis.mapper.UserMapper.selAll");

        /**直接调用Mapper.xml进行selectOne查询*/
        User user1 = session.selectOne("com.mybatis.mapper.UserMapper.selOne",1);

        /**直接调用Mapper.xml进行selectMap查询*/
        Map<Object,Object> userMap0 = session.selectMap("com.mybatis.mapper.UserMapper.selMap",1,"uid");

        /**获取接口对象*/
        UserMapper userMapper = session.getMapper(UserMapper.class);

        /**查询所有用户返回List*/
        List<User> list1 = userMapper.selAll();

        /**根据Id查询用户*/
        User user = userMapper.selOne(2);
        System.out.println("InterfaceBind_SelectOne");
        System.out.println(user.toString());

        /**根据Id查询用户返回Map*/
        Map<Long,User> userMap = userMapper.selMapInterface(1,2);

        /**使用Map传递数据查询分页*/
        Map<String,Object> paramMap = new HashMap<>(2);
        List<User> userList;
        int pageStart,pageSize;
        pageSize = 2;
        paramMap.put("pageSize",pageSize);
        for (int i = 0; i < 5; i++) {
            pageStart = i*pageSize;
            paramMap.put("pageStart",pageStart);
            userList = userMapper.selPageByMap(paramMap);
            /*logger.info(userList.toString());*/
        }

        /**使用@param注解传递数据查询分页*/
        for (int i = 0; i < 5; i++) {
            pageStart = i*pageSize;
            userList = userMapper.selPageByParam(pageStart,pageSize);
            logger.info(userList.toString());
        }
        session.close();
    }

}
