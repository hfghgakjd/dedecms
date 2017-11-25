package com.snowfog.service;

import com.snowfog.entity.Menu;
import com.snowfog.entity.TreeNode;

import java.util.List;

public interface MenuService {

    /**
     * 根据父级菜单获取子菜单
     * @param parentId 父级菜单id
     * @return
     */
    List<Menu> getMenusByParentId(String parentId);

    /**
     * 根据父级id查询子菜单
     * @param pId
     * @return
     */
    List<TreeNode> getTreeMenu(String pId);
}
