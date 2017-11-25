package com.snowfog.controller;


import com.snowfog.entity.Menu;
import com.snowfog.entity.TreeNode;
import com.snowfog.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Resource(name="menuService")
    private MenuService menuService;

    /**
     * 获取panel菜单
     * @author snowfog-shao
     * @return
     */
    @RequestMapping(path = "/getAll",method= RequestMethod.POST)
    @ResponseBody
    public List<Menu> getAll(){
        List<Menu> menus = null;
        try{
            menus =  menuService.getMenusByParentId("0");
        }catch(Exception e){
            System.out.println(e);
        }
        return menus;
    }

    @RequestMapping(path="/getTrees",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> getTrees(String pId){
        List<TreeNode> trees = menuService.getTreeMenu(pId);
        return trees;
    }
}
