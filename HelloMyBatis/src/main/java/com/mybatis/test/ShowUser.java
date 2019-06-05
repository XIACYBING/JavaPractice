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
        for(User user0 : list0){
            System.out.println("selectList:" + user0.toString());
            logger.info("selectList:" + user0.toString());
        }

        /**直接调用Mapper.xml进行selectOne查询*/
        User user1 = session.selectOne("com.mybatis.mapper.UserMapper.selOne",1);
        System.out.println("selectOne:" + user1.toString());

        /**直接调用Mapper.xml进行selectMap查询*/
        Map<Object,Object> userMap0 = session.selectMap("com.mybatis.mapper.UserMapper.selMap",1,"uid");
        System.out.println("selectMap:" + userMap0);

        /**获取接口对象*/
        UserMapper userMapper = session.getMapper(UserMapper.class);

        /**查询所有用户返回List*/
        List<User> list1 = userMapper.selAll();
        System.out.println("InterfaceBind_SelectAll");
        for(User user2 : list1){
            System.out.println(user2.toString());
        }

        /**根据Id查询用户*/
        User user = userMapper.selOne(2);
        System.out.println("InterfaceBind_SelectOne");
        System.out.println(user.toString());

        /**根据Id查询用户返回Map*/
        Map<Long,User> userMap = userMapper.selMapInterface(1,2);
        System.out.println("InterfaceBind_SelectMap");
        System.out.println(userMap.get(1L).toString());
        System.out.println(userMap.get(2L).toString());

        session.close();
    }

}
