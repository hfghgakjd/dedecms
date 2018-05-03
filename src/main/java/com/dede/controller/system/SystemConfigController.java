package com.dede.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc 系统管理控制器
 * @author dede-shao
 */
@Controller
public class SystemConfigController {

    /**
     * @desc 进入菜单管理页面
     * @author dede-shao
     */
    @RequestMapping(path="/system/menu/index")
    public String index(){
        return "system/menu/index";
    }
}
