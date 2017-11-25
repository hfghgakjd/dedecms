package com.snowfog.service.impl;

import com.snowfog.dao.RoleDao;
import com.snowfog.dao.UserDao;
import com.snowfog.entity.Role;
import com.snowfog.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role = roleDao.findRoleByRoleId(ObjectUtils.isEmpty(user)?null:user.getRoleId());
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
        grantedAuthorities.add(grantedAuthority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
