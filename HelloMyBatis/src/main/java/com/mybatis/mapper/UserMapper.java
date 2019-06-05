package com.mybatis.mapper;

import com.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: ideaWorkspace
 * @description: UserMapper.xml的接口
 * @author: wang.yubin
 * @create: 2019/06/04
 */
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return 返回用户信息的List集合
     */
    List<User> selAll();

    /**
     * 根据用户id查询用户信息
     * @param uid 用户id
     * @return 返回一个User
     */
    User selOne(int uid);

    /**
     * 根据用户id查询用户信息，
     * @param uid0 用户id
     * @param uid1 用户id
     * @return 返回一个Map集合，key为uid，value为User对象
     */
    @MapKey("uid")
    Map<Long,User> selMapInterface(int uid0,int uid1);

    /**
     * 使用Map查询分页
     * @param paramMap 包含pageStart和pageSize
     * @return 返回一个List集合
     */
    List<User> selPageByMap(Map<String,Object> paramMap);

    /**
     * 使用@Param注解查询分页（@Param注解底层还是使用Map）
     * @param pageStart 当前页开始条数
     * @param pageSize 当前页数据量
     * @return 返回一个List集合
     */
    List<User> selPageByParam(@Param("pageStart") int pageStart,@Param("pageSize") int pageSize);

    /**
     * 插入一条用户信息
     * @param user 包含用户信息的User对象
     * @return 返回一个int，代表数据库中被影响的行数
     */
    int insOne(User user);

    /**
     * 修改zhangqi的密码
     * @param pwd 新密码
     * @return 返回数据库中被影响的行数
     */
    int updPwd(String pwd);

    /**
     * 根据用户id删除用户信息
     * @param uid 用户id
     * @return 返回数据库中被影响的行数
     */
    int delOne(Long uid);

}
