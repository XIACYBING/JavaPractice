package com.xia.hiber.main;

import com.xia.hiber.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

/**
 * @program: ideaWorkspace
 * @description: 测试Hibernate的第一个类
 * @author: wang.yubin
 * @create: 2019/07/06
 */
public class Test {

    public static void main(String[] args) {
        Configuration cf = new Configuration();
        cf.configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        User user = new User("test32",new Date(System.currentTimeMillis()));
        session.save(user);
        session.close();
    }

}
