package com.dede.dao;


import com.dede.entity.TreeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuDao {

    /**
     * 根据父级查询菜单
     * @param parentId
     * @return {@link List}<{@link TreeNode}>
     *
     */
    List<TreeNode> getMenuByParentId(@Param("parentId") String parentId);


    /**
     * 根据父级菜单查询所有的子菜单
     * @param pId
     * @return
     */
    List<TreeNode> getMenuTrees(String pId);

    /**
     * 查询菜单表--分页
     * @param params
     *     <p><strong>1.page:</strong>当前页</p>
     *     <p><strong>2.rows:</strong>每页大小</p>
     * @return
     */
    List<Map<String,Object>> getTreePagination(Map<String, Object> params);

    /**
     * 查询菜单表总记录数
     * @param params
     *     <p><strong>1.page:</strong>当前页</p>
     *     <p><strong>2.rows:</strong>每页大小</p>
     * @return
     */
    int getTreePaginationCount(Map<String, Object> params);

    /**
     * 新增菜单
     * @param paramsMap
     * @return
     */
	int insert(Map<String, Object> paramsMap);
}
