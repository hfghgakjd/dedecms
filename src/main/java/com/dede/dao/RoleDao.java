package com.dede.dao;

import com.dede.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
	 * <li><strong>描述</strong>: 根据url获取url当前需要的角色</li>
	 * <li><strong>方法名</strong>: findRoleTypeByUrl</li>
	 *
	 * @param url
	 * @return {@link List}<{@link Role}>
	 * @author snowfog shao
	 */
	List<Role> findRoleTypeByUrl(@Param("url") String url);
}
