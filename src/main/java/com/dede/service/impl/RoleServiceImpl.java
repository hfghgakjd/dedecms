package com.dede.service.impl;

import com.dede.dao.RoleDao;
import com.dede.entity.Role;
import com.dede.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    *     <li><strong>描述</strong>: 根据url获取url需要的角色</li>
    *     <li><strong>方法名</strong>: findRoleTypeByUrl</li>
    * @param requestUrl
    * @return {@link List}<{@link Role}>
    * @author snowfog shao
    */
    @Override
    public List<Role> findRoleTypeByUrl(String requestUrl) {
        return roleDao.findRoleTypeByUrl(requestUrl);
    }
}
