package com.zuche.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zuche.entity.Joins;
import com.zuche.entity.Store;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreUser;
import com.zuche.intercepter.Token;
import com.zuche.service.customer.JoinsService;
import com.zuche.service.store.StoreCarService;
import com.zuche.service.store.StoreService;
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
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreCarService storeCarService;
	
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Integer id) throws Exception {
		
		StoreUser storeUser = (StoreUser) request.getSession().getAttribute("storeUser");
		
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
			Store store = storeService.findStoreByField(new Integer(19).toString(), "id");
			request.getSession().setAttribute("store", store);
			List<StoreCar> storeCars = storeCarService.findCarByField(store.getId().toString(), "storeId");
			model.addAttribute("storeCars", storeCars);
			break;
		case "CarDetail":
			result = "customer/carDetail";
			String getDate = request.getParameter("getDate");
			String returnDate = request.getParameter("returnDate");
			String rentdays = request.getParameter("rentdays");
			request.getSession().setAttribute("getDate", getDate);
			request.getSession().setAttribute("returnDate", returnDate);
			request.getSession().setAttribute("rentdays", rentdays);
			
			if (id != null && id.intValue() != 0) {
				List<StoreCar> existStoreCars = storeCarService.findCarByField(id.toString(), "id");
				if (existStoreCars != null && existStoreCars.size() > 0) {
					model.addAttribute("storeCar", existStoreCars.get(0));
				}
			}
			break;
		case "OrderPreview":
			if (id != null && id.intValue() != 0) {
				List<StoreCar> existStoreCars = storeCarService.findCarByField(id.toString(), "id");
				if (existStoreCars != null && existStoreCars.size() > 0) {
					model.addAttribute("storeCar", existStoreCars.get(0));
				}
			}
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
		
		// 设置信息
		model.addAttribute("resultCode", 1);  // 1为成功，2为失败
		model.addAttribute("resultText", "申请完成，请留意邮件通知！"); // 显示结果
		model.addAttribute("redirectText", "首页");  // 跳转到首页
		model.addAttribute("redirectUrl", "/toIndex");  // 跳转链接
		return "common/result";
	}
}
