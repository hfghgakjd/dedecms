package com.dede.controller;

import com.dede.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * url的控制器
 * @author shaojing
 */
@Controller
public class UrlController {

	@Resource(name="userService")
	private UserService userService;


	/**
	 * 进入首页
	 * 
	 * @author shaojing
	 * @return
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(path="/loginPage",method=RequestMethod.GET)
	public String toLoginPage(){
		return "loginPage";
	}

	@RequestMapping(path="/test",method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String,Object>> test(){
		List<Map<String,Object>> result = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("itemid","aaa");
		map.put("product","aaabbbb");
		map.put("listprice","fsojdfo");
		map.put("unitcost","fsjodjf");
		map.put("arrtibute","jsdfs");
		map.put("status","sjodfj");
		map.put("itemid","jodso");
		result.add(map);
		return result;
	}
}
