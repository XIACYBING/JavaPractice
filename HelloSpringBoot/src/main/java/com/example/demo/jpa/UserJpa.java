package com.example.demo.jpa;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * JpaRepository是SpringDataJpa提供的简单数据操作接口
 * JpaSpecificationExecutor是SpringDataJpa提供的复杂查询接口
 * Serializable是SpringDataJpa提供的序列化接口
 */
@Component
public interface UserJpa extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>, Serializable{
}
