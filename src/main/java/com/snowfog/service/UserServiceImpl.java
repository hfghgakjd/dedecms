package com.snowfog.service;

import com.snowfog.dao.UserDao;
import com.snowfog.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户业务逻辑实现类
 * @author snowfog-shao
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name="userDao")
    private UserDao userDao;

    /**
     * 根据用户名查询用户的id
     * @param userName
     * @return
     */
    @Override
    public String getUserIdByUserName(String userName) {
        //构造参数
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("username",userName);

        //查询
        User user = userDao.findUserByUserName(paramsMap);
        return ObjectUtils.isEmpty(user)?null:user.getId();
    }
}
