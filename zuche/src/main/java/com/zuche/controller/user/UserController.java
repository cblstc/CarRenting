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
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zuche.entity.User;
import com.zuche.entity.UserCar;
import com.zuche.entity.UserInfo;
import com.zuche.intercepter.Token;
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
		if (page.equals("Regist"))
			return "user/regist";
		else if (page.equals("Login"))
			return "user/login";
		else 
			return "errorPage";
	}
	
	
	/**
	 * 注册
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/regist")
	@Token(remove=true)
	public String regist(User user, Model model) throws Exception {
		// 数据正确时才能执行该方法
		
		// 保存用户
		userService.saveUser(user);
		
		// 设置信息
		model.addAttribute("resultCode", 1);  // 1为成功，2为失败
		model.addAttribute("resultText", "恭喜！注册成功！"); // 显示结果
		model.addAttribute("redirectText", "登录");  // 跳转到登录页面
		model.addAttribute("redirectUrl", "user/toLogin");  // 跳转链接
		return "common/result";
	}
	
	/**
	 * 校验电话的唯一性
	 * @param phone 电话
	 * @param response
	 * @throws Exception
	 */
	/*@RequestMapping("/phoneValidate")
	public void phoneValidate(String phone, HttpServletResponse response) throws Exception {
		// 电话唯一性判断
		User existUser = userService.findUserByPhone(phone);
		if (existUser == null)
			response.getWriter().print("1");  // 电话可以使用
		else
			response.getWriter().print("2");  // 电话已经被注册
	}*/
	
	/**
	 * 登录
	 * @param user 登录信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	@Token(remove=true)
	public String login(User user, HttpServletRequest request, Model model) throws Exception {
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
			return "redirect:/toIndex";
		}
	}
	
	/**
	 * 字段校验
	 * @param username 用户名
	 * @param phone 手机
	 * @param email 邮箱
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/fieldValidate", method=RequestMethod.POST)
	public void fieldValidate(String username, String phone, String email, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		User existUser = null;
		if (username != null && !username.trim().equals("")) {
			existUser = userService.findUserByField(username, "username");
		} else if (phone != null && !phone.trim().equals("")) {
			existUser = userService.findUserByField(phone, "phone");
		} else if (email != null && !email.trim().equals("")) {
			existUser = userService.findUserByField(email, "email");
		}
		response.getWriter().print(JSON.toJSON(existUser));
	}
	
	@RequestMapping(value="/saveField", method=RequestMethod.POST)
	@Token(remove=true)
	public String saveField(String username, String phone, String email, HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		
		if (username != null && !username.trim().equals("")) {
			user.setUsername(username);
		} else if (phone != null && !phone.trim().equals("")) {
			user.setPhone(phone);
		} else if (email != null && !email.trim().equals("")) {
			user.setEmail(email);
		}
		
		userService.updateUser(user);  // 更新用户
		
		request.getSession().setAttribute("user", user);
		return "redirect:/toMyCargo";
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
