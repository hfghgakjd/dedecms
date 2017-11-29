package com.snowfog.auth;

import com.snowfog.service.RoleService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author snowfog shao
 * @desc 路径拦截配置
 * @date 17-11-28下午12:59
 */
@Component
public class CustomFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource(name = "roleService")
    private RoleService roleService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object; //当前对象
        if (isMatcherAllowedRequest(fi)) return null;
        List<ConfigAttribute> configAttributes = getMatcherConfigAttribute(fi.getRequestUrl());
        return configAttributes.size() > 0 ? configAttributes : deniedRequest(); //返回当前路径所需角色，如果没有则拒绝访问
    }

    /**
     * 获取当前路径所需要的角色
     *
     * @param requestUrl 请求url
     * @return {@link List}<{@link String}>
     */
    private List<ConfigAttribute> getMatcherConfigAttribute(String requestUrl) {
        return roleService.findRoleTypeByUrl(requestUrl).stream()
                .map(role -> new SecurityConfig(role.getType()))
                .collect(Collectors.toList());
    }

    /**
     * 判断当前请求是否在允许请求的范围内
     *
     * @param fi 当前请求
     * @return 是否在范围中
     * @author snowfog-shao
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi) {
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
    }

    /**
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest() {
        return Arrays.asList("/login", "/css/**", "/fonts/**", "/js/**", "/scss/**", "/img/**");
    }

    /**
     * @return 默认拒绝访问配置
     */
    private List<ConfigAttribute> deniedRequest() {
        return Collections.singletonList(new SecurityConfig("ROLE_DENIED"));
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
