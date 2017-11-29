package com.snowfog.dao;

import com.snowfog.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    /**
     * 根据roleId 查询角色
     *
     * @param roleId
     * @return
     */
    Role findRoleByRoleId(@Param("roleId") String roleId);

    /**
     * 根据url获取角色
     *
     * @param url 请求url
     * @return {@link List}<{@link String}>
     */
    List<Role> findRoleByUrl(@Param("url") String url);
}
