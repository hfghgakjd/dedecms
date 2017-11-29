package com.snowfog.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author snowfog shao
 * @desc 保存用户的用户名，密码，角色等信息
 * @date 17-11-26下午10:04
 */
public class UserPrincipal implements UserDetails{

    private User user;

    private List<String> roleType;

    public UserPrincipal(User user,List<String> roleType){
        this.user = user;
        this.roleType = roleType;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleType.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
