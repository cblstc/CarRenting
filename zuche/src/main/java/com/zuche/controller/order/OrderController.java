package com.zuche.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.service.user.UserService;

/**
 * 
 * 订单Controller类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
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
		/*case "Reserve":
			List<UserCar> cars = userService.selectCars();
			if (cars != null)
				model.addAttribute("car", cars.get(0));
			result = "order/reserve";
			break;*/
		default:
			result = "errorPage";
			break;
		}
		
		return result;
	}
	
	@RequestMapping("/generateOrder")
	public String generateOrder() throws Exception {
		// 生成订单
		// 支付
		return "/index";
	}
}
