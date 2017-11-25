package com.snowfog.dao;

import com.snowfog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository(value = "userDao")
public interface UserDao {


    /**
     * 根据username 查询用户
     *
     * @param params
     * @return
     */
    User findUserByUserName(Map<String, Object> params);
}