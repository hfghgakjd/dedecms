package com.dede.service;



public interface UserService {

    /**
     * 查询用户id,根据用户名
     * @param userName
     * @return
     */
    String getUserIdByUserName(String userName);
}
