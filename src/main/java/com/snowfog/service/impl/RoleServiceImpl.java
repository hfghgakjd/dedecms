package com.snowfog.service.impl;

import com.snowfog.dao.RoleDao;
import com.snowfog.entity.Role;
import com.snowfog.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author snowfog shao
 * @desc 角色业务逻辑实现类
 * @date 17-11-28下午8:57
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    /**
     * 根据url获取角色
     *
     * @param requestUrl url
     * @return {@link List}<{@link String}>
     */
    @Override
    public List<Role> findRoleTypeByUrl(String requestUrl) {
        return roleDao.findRoleByUrl(requestUrl);
    }
}
