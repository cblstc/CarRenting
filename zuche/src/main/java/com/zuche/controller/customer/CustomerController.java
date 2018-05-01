package com.zuche.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zuche.entity.Joins;
import com.zuche.intercepter.Token;
import com.zuche.service.customer.JoinsService;
import com.zuche.service.system.GarageService;
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
	
	@Autowired
	private JoinsService joinsService;
	
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, Model model) throws Exception {
		
		String result = null;
		
		switch (page) {
		case "Index":
			result = "index";
			break;
		case "JoinUs":
			result = "customer/joinUs";
			break;
		case "CarList":
			result = "customer/carList";
			break;
		case "CarDetail":
			result = "customer/carDetail";
			break;
		case "OrderPreview":
			result = "customer/orderPreview";
			break;
		default:
			result = "errorPage";
			break;
		}
		
		return result;
	}
	
	/**
	 * 加盟
	 * @param model
	 * @param joins  加盟类对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/joinUs", method=RequestMethod.POST)
	@Token(remove=true)
	public String joinUs(Model model, Joins joins) throws Exception {
		joinsService.saveJoins(joins);
		return null;
	}
}
