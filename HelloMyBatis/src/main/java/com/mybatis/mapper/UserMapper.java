package com.mybatis.mapper;

import com.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @program: ideaWorkspace
 * @description: UserMapper.xml的接口
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public interface UserMapper {

    List<User> selAll();

    User selOne(int uid);

    @MapKey("uid")
    Map<Long,User> selMapInterface(int uid0,int uid1);

}
