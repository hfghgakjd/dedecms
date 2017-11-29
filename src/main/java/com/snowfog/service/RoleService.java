package com.snowfog.service;

import com.snowfog.entity.Role;

import java.util.List;

/**
 * @author snowfog shao
 * @desc 角色业务逻辑接口
 */
public interface RoleService {

    /**
     * 根据url获取角色
     * @param requestUrl url
     * @return {@link List}<{@link String}>
     */
    List<Role> findRoleTypeByUrl(String requestUrl);
}
