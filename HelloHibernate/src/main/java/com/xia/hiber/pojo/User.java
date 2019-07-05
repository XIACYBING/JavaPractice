package com.xia.hiber.pojo;

import java.sql.Date;

/**
 * @program: ideaWorkspace
 * @description: Hibernate测试实体类
 * @author: wang.yubin
 * @create: 2019/07/06
 */
public class User {

    private int uid;

    private String uname;

    private Date birthday;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(String uname, Date birthday) {
        this.uname = uname;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                       "uid=" + uid +
                       ", uname='" + uname + '\'' +
                       ", birthday=" + birthday +
                       '}';
    }
}
