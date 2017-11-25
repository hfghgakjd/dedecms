package com.snowfog.dao;

import com.snowfog.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

    /**
     * 根据roleId 查询角色
     * @param roleId
     * @return
     */
    Role findRoleByRoleId(@Param("roleId") String roleId);
}
