package com.snowfog.controller;


import com.snowfog.Utils.ConvertUtils;
import com.snowfog.annotation.ControllerLog;
import com.snowfog.entity.TreeNode;
import com.snowfog.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

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
    @ControllerLog(desc = "获取panel菜单")
    public List<TreeNode> getAll(){
        List<TreeNode> menus = null;
        try{
            menus =  menuService.getMenusByParentId("0");
        }catch(Exception e){
            System.out.println(e);
        }
        return menus;
    }

    @RequestMapping(path="/getTrees",method = RequestMethod.POST)
    @ResponseBody
    @ControllerLog(desc="根据父级获取子菜单")
    public List<TreeNode> getTrees(String pId){
        return menuService.getTreeMenu(pId);
    }

    /**
     * <p>
     *   描述: 查询菜单
     * </p>
     * @param page 当前页
     * @param rows 每页条数
     * @return
     */
    @RequestMapping(path="/listTrees/pagination",method = RequestMethod.POST)
    @ResponseBody
    @ControllerLog(desc="分页查询")
    public Map<String,Object> getTreesPagination(String page,String rows){
        //获取并构造参数
        Map<String,Object> params = new HashMap<>();
        params.put("rows",ConvertUtils.cInt(rows,0));
        params.put("start", (ConvertUtils.cInt(page)-1)*ConvertUtils.cInt(rows));
        return menuService.getTreePagination(params);
    }
    
    @RequestMapping(path="/save",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
    @ResponseBody
    @ControllerLog(desc="新增菜单")
    public Map<String,Object> save(@RequestParam Map<String,Object> params){
        System.out.println(params.toString());
        boolean bool = menuService.addMenu(params);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("isSave",bool);
    	return resultMap;
    }
}
