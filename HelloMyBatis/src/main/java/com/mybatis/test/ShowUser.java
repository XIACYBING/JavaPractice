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
import java.util.*;

/**
 * @program: ideaWorkspace
 * @description: 展示用户的测试类
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public class ShowUser {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(ShowUser.class);
        InputStream in = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        /**事务不进行自动提交*/
        SqlSession session = sessionFactory.openSession(false);

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
        Map<String,Object> pageMap = new HashMap<>(8);
        List<User> userList;
        int pageStart,pageSize;
        pageSize = 2;
        paramMap.put("pageSize",pageSize);
        for (int i = 0; i < 5; i++) {
            pageStart = i*pageSize;
            paramMap.put("pageStart",pageStart);
            userList = userMapper.selPageByMap(paramMap);
            pageMap.put("第" + i + "页",userList);
        }

        /**使用@param注解传递数据查询分页*/
        for (int i = 0; i < 5; i++) {
            pageStart = i*pageSize;
            userList = userMapper.selPageByParam(pageStart,pageSize);
            pageMap.put("第" + i + "页",userList);
        }

        /**新增用户*/
        User newUser = new User();
        newUser.setName("zhangqi");
        newUser.setPwd("z");
        int i = userMapper.insOne(newUser);
        if (i == 1){
            logger.info("插入用户成功：" + newUser.toString());
            session.rollback();
        }else {
            logger.error("插入用户失败：" + i);
            session.rollback();
        }

        /**修改用户密码*/
        i = userMapper.updPwd("zh");
        if (i == 1){
            logger.info("更新用户信息成功：" + i);
            session.rollback();
        }else {
            logger.error("更新用户信息失败：" + i);
            session.rollback();
        }

        /**删除用户*/
        i = userMapper.delOne(12L);
        if (i == 1){
            logger.info("删除用户成功：" + i);
            session.rollback();
        }else {
            logger.error("删除用户失败：" + i);
            session.rollback();
        }

        session.close();
    }

}
