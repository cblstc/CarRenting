package com.zuche.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.intercepter.Token;
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
	private GarageService garageService;
	
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
		case "MyCargo":
			result = "user/improveAccount";
			break;	
		/*case "CarList":
			List<Garage> garages = garageService.findCarByCondition(null, null, null, 1);
			model.addAttribute("garages", garages);
			result = "customer/carList";
			break;*/
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
	
}
