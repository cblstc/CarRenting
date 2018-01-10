package com.zuche.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuche.entity.User;
import com.zuche.entity.UserCar;
import com.zuche.entity.UserInfo;
import com.zuche.service.system.BrandService;
import com.zuche.service.system.ConfigurationService;
import com.zuche.service.system.ModelService;
import com.zuche.service.user.UserService;

/**
 * 用户模块控制类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ConfigurationService configurationService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	public String toPage(@PathVariable String page, Model model) throws Exception {
		
		if (page.equals("Index"))
			return "user/index";
		else if (page.equals("Regist"))
			return "user/regist";
		else if (page.equals("Login"))
			return "user/login";
		else if (page.equals("EditInfo"))
			return "user/info";
		else if (page.equals("MyCar"))
			return "user/car";
		else if (page.equals("AddCar")) {
			model.addAttribute("brands", brandService.selectBrands());
			model.addAttribute("models", modelService.selectModels());
			model.addAttribute("configurations", configurationService.selectConfigurations());
			model.addAttribute("method", "add");
			return "user/saveCar";
		}
		else if (page.equals("EditCar")) {
			model.addAttribute("method", "edit");
			return "user/saveCar";
		}	
		else 
			return "errorPage";
	}
	
	
	/**
	 * 注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/regist")
	public String regist(User user) throws Exception {
		// 注册判断
		userService.saveUser(user);
		return "redirect:/user/toLogin";
	}
	
	/**
	 * 校验电话的唯一性
	 * @param phone 电话
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/phoneValidate")
	public void phoneValidate(String phone, HttpServletResponse response) throws Exception {
		// 电话唯一性判断
		User existUser = userService.findUserByPhone(phone);
		if (existUser == null)
			response.getWriter().print("1");  // 电话可以使用
		else
			response.getWriter().print("2");  // 电话已经被注册
	}
	
	/**
	 * 登录
	 * @param user 登录信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request, Model model) throws Exception {
		System.out.println("电话：" + user.getPhone());
		System.out.println("用户名：" + user.getUsername());
		System.out.println("邮箱：" + user.getEmail());
		System.out.println("密码：" + user.getPassword());
		// 查询是否存在
		User existUser = userService.findUser(user);
		if (existUser == null) {
			model.addAttribute("loginError", "账户或密码错误");
			return "forward:/user/toLogin";  // 账户或密码错误
		} else if (existUser.getStatus().intValue() == 2) {
			model.addAttribute("loginError", "账户被冻结");
			return "forward:/user/toLogin";  // 账户被冻结
		} else {
			request.getSession().setAttribute("user", existUser);
			return "redirect:/user/toIndex";
		}
	}
	
	/**
	 * 完善信息
	 * @param userInfo 用户信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editInfo")
	public String editInfo(UserInfo userInfo, HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");  // 从session获取user对象
		userService.saveInfo(userInfo, user);
		return "redirect:/user/toIndex";
	}
	
	/**
	 * 退登
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("user");  // 销毁user
		return "redirect:/user/toIndex";
	}
	
	@RequestMapping("/saveCar/{method}")
	public String saveCar(@PathVariable String method, UserCar userCar, HttpServletRequest request, Model model) throws Exception {
		User user = (User) request.getSession().getAttribute("user");  // 从session获取user对象
		userService.saveCar(userCar, user, method); // 保存我的车辆
		return "forward:/user/toMyCar";
	}
}
