package com.snowfog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.snowfog.dao.RoleDao;
import com.snowfog.dao.UserDao;
import com.snowfog.entity.Role;
import com.snowfog.entity.User;
import com.snowfog.entity.UserPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        User user = userDao.findUserByUserName(params);

        return new UserPrincipal(user,getRoles(user));
    }

    /**
     * 根据user获取角色
     * @param user
     * @return {@link List}<{@link String}>
     */
    private List<String> getRoles(User user) {
        Role role = roleDao.findRoleByRoleId(ObjectUtils.isEmpty(user)?null:user.getRoleId());
        List<String> roles = new ArrayList<>();
        roles.add(role.getType());
        return roles;
    }


}
