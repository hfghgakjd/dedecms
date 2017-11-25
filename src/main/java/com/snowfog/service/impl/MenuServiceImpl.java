package com.snowfog.service.impl;

import com.snowfog.dao.MenuDao;
import com.snowfog.entity.Menu;
import com.snowfog.entity.TreeNode;
import com.snowfog.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;


    @Override
    public List<Menu> getMenusByParentId(String parentId) {
        List<Menu> menus =  menuDao.getMenuByParentId(parentId);
        return menus;
    }

    @Override
    public List<TreeNode> getTreeMenu(String pId) {
        List<TreeNode> trees = menuDao.getMenuTrees(pId);

        return trees;

    }
}
