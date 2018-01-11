package com.zuche.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.entity.UserCar;
import com.zuche.service.user.UserService;

/**
 * 顾客界面Controller类
 * @author cbl
 *
 */
@Controller
public class CustomerController {
	
	@Autowired 
	private UserService userService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	public String toPage(@PathVariable String page, Model model) throws Exception {
		
		String result = null;
		
		switch (page) {
		case "Index":
			result = "index";
			break;
		case "MyCargo":
			result = "user/improveAccount";
			break;
		default:
			result = "errorPage";
			break;
		}
		
		return result;
	}
}
