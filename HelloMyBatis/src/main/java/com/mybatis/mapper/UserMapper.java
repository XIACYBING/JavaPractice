package com.mybatis.mapper;

import com.mybatis.entity.User;

import java.util.List;

/**
 * @program: ideaWorkspace
 * @description: UserMapper.xml的接口
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public interface UserMapper {

    List<User> selAll();

}
