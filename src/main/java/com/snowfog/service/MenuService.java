package com.snowfog.service;

import com.snowfog.entity.TreeNode;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * 根据父级菜单获取子菜单
     * @param parentId 父级菜单id
     * @return
     */
    List<TreeNode> getMenusByParentId(String parentId);

    /**
     * 根据父级id查询子菜单
     * @param pId
     * @return
     */
    List<TreeNode> getTreeMenu(String pId);

    /**
     * <p>
     *     描述: 查询菜单表
     * </p>
     * @param params
     *     <p><strong>1.</strong>page:当前页</p>
     *     <p><strong>2.</strong>rows:每页大小</p>
     * @return
     */
    Map<String,Object> getTreePagination(Map<String, Object> params);

    /**
     * <p>
     * 	   描述:	新增菜单
     * </p>
     * @param params
     * @return boolean (true or false)
     */
	boolean addMenu(Map<String, Object> params);
}
