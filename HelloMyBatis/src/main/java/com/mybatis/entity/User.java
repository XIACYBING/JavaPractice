package com.mybatis.entity;

import javax.persistence.Entity;

/**
 * @program: ideaWorkspace
 * @description: 用户实体类
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public class User {

    private Long uid;

    private String name;

    private String pwd;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                       "uid=" + uid +
                       ", name='" + name + '\'' +
                       ", pwd='" + pwd + '\'' +
                       '}';
    }
}
