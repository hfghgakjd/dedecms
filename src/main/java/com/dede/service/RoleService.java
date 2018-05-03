package com.dede.service;

import com.dede.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author shao
 * @desc 角色业务逻辑接口
 */
public interface RoleService {

    /**
     * 根据url获取角色
     * @param requestUrl url
     * @return {@link List}<{@link Role}>
     */
    List<Role> findRoleTypeByUrl(String requestUrl);
}
