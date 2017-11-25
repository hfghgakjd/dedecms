package com.snowfog.dao;


import com.snowfog.entity.TreeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.snowfog.entity.Menu;

@Repository
public interface MenuDao {

    /**
     * 根据父级查询菜单
     * @param parentId
     * @return {@link List}<{@link Menu}>
     *
     */
    List<Menu> getMenuByParentId(@Param("parentId") String parentId);


    /**
     * 根据父级菜单查询所有的子菜单
     * @param pId
     * @return
     */
    List<TreeNode> getMenuTrees(String pId);
}
