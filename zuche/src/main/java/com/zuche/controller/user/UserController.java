package com.zuche.controller.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.zuche.entity.User;
import com.zuche.entity.UserInfo;
import com.zuche.intercepter.Token;
import com.zuche.service.user.UserInfoService;
import com.zuche.service.user.UserService;
import com.zuche.utils.MD5Utils;
import com.zuche.utils.UUIDUtils;

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
	private UserInfoService userInfoService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, Model model, HttpServletRequest request) throws Exception {
		if (page.equals("Regist"))
			return "user/regist";
		else if (page.equals("Login"))
			return "user/login";
		else if (page.equals("ImproveAccount"))
			return "user/improveAccount";
		else if (page.equals("AuthenticationAccount")) {
			User user = (User) request.getSession().getAttribute("user");
			UserInfo userInfo = userInfoService.findUserInfoByField(user.getId().toString(), "userId");
			model.addAttribute("userInfo", userInfo);
			return "user/authenticationAccount";
		}
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
	 * @param oldPassword 旧密码
	 * @param idcard 身份证号码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/fieldValidate", method=RequestMethod.POST)
	public void fieldValidate(String username, String phone, String email, String oldPassword, String idcard, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		User existUser = null;
		if (username != null && !username.trim().equals("")) {
			existUser = userService.findUserByField(username, "username");
		} else if (phone != null && !phone.trim().equals("")) {
			existUser = userService.findUserByField(phone, "phone");
		} else if (email != null && !email.trim().equals("")) {
			existUser = userService.findUserByField(email, "email");
		} else if (oldPassword != null && !oldPassword.trim().equals("")) {
			User user = (User) request.getSession().getAttribute("user");
			if (user.getPassword().equals(MD5Utils.getMD5Str(oldPassword))) {
				response.getWriter().print("1");
				return;
			} else {
				response.getWriter().print("0");
				return;
			}
		} else if (idcard != null && !idcard.trim().equals("")) {
			UserInfo existUserInfo = userInfoService.findUserInfoByField(idcard, "idcard");
			response.getWriter().print(JSON.toJSON(existUserInfo));
			return;
		}
		response.getWriter().print(JSON.toJSON(existUser));
	}
	
	/**
	 * 保存用户字段
	 * @param username 用户名
	 * @param phone 联系电话
	 * @param email 邮箱
	 * @param password 密码
	 * @param idcard 身份证号码
	 * @param sex 性别
	 * @param request 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveField", method=RequestMethod.POST)
	@Token(remove=true)
	public String saveField(String username, String phone, String email, String password, String idcard, 
			Integer sex, HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		
		if (username != null && !username.trim().equals("")) {
			user.setUsername(username);
		} else if (phone != null && !phone.trim().equals("")) {
			user.setPhone(phone);
		} else if (email != null && !email.trim().equals("")) {
			user.setEmail(email);
		} else if (password != null && !password.trim().equals("")) {
			user.setPassword(password);
		}
		userService.updateUser(user);  // 更新用户
		
		request.getSession().setAttribute("user", user);
		return "redirect:/toMyCargo";
	}
	
	/**
	 * 保存用户信息字段
	 * @param idcard 身份证号码
	 * @param name 姓名
	 * @param sex 性别
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveInfoField", method=RequestMethod.POST)
	@Token(remove=true)
	public String saveInfoField(String idcard, Integer sex, String name, HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		UserInfo existUserInfo = userInfoService.findUserInfoByField(user.getId().toString(), "userId");  // 需要更新的用户信息数据
		UserInfo saveUserInfo = new UserInfo();  // 需要插入的用户信息数据
		saveUserInfo.setUserId(user.getId());
		
		if (idcard != null && !idcard.trim().equals("")) {
			if (existUserInfo == null) {
				// 如果该用户还没有用户信息，那么保存
				saveUserInfo.setIdcard(idcard);
				userInfoService.saveUserInfo(saveUserInfo); // 保存用户信息
			} else {
				// 如果该用户已经有用户信息，那么更新
				existUserInfo.setIdcard(idcard);
				userInfoService.updateUserInfo(existUserInfo);  // 更新用户信息
			}
			return "redirect:/user/toAuthenticationAccount";
		} else if (sex != null && sex.intValue() != 0) {
			if (existUserInfo == null) {
				// 如果该用户还没有用户信息，那么保存
				saveUserInfo.setSex(sex);
				userInfoService.saveUserInfo(saveUserInfo); // 保存用户信息
			} else {
				// 如果该用户已经有用户信息，那么更新
				existUserInfo.setSex(sex);
				userInfoService.updateUserInfo(existUserInfo);  // 更新用户信息
			}
		} else if (name != null && !name.equals("")) {
			if (existUserInfo == null) {
				// 如果该用户还没有用户信息，那么保存
				saveUserInfo.setName(name);
				userInfoService.saveUserInfo(saveUserInfo); // 保存用户信息
			} else {
				// 如果该用户已经有用户信息，那么更新
				existUserInfo.setName(name);
				userInfoService.updateUserInfo(existUserInfo);  // 更新用户信息
			}
		}
		
		return "redirect:/user/toAuthenticationAccount";
	}
	
	/**
	 * 异步保存图片
	 * @param model
	 * @param request
	 * @param response
	 * @param file 图片
	 * @param photoName 图片名称：如身份证图片、驾驶证图片
	 * @throws Exception
	 */
	@RequestMapping(value="uploadPhoto",method=RequestMethod.POST)
	public void uploadPhoto(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam("photo") CommonsMultipartFile file, String photoName) throws Exception  {
		if (!file.isEmpty()) {
			InputStream in = file.getInputStream();
			String fileName = saveImage(request, in); // 保存图片
			
			// 保存图片名到数据库
			User user = (User) request.getSession().getAttribute("user");
			UserInfo userInfo = userInfoService.findUserInfoByField(user.getId().toString(), "userId");
			if (userInfo != null) {
				if (photoName != null && photoName.trim().equals("idcardPhoto")) {
					// 上传的是身份证图片
					if (userInfo.getIdcardphoto() != null && !userInfo.getIdcardphoto().equals("")) {
						// 如果原来有图片，那么删除原来的图片
						deleteImage(request, userInfo.getIdcardphoto());
					}
					userInfo.setIdcardphoto(fileName);
				} else if (photoName != null && photoName.trim().equals("licencePhoto")) {
					// 上传的是驾驶证正面
					if (userInfo.getLicencephoto() != null && !userInfo.getLicencephoto().equals("")) {
						// 如果原来有图片，那么删除原来的图片
						deleteImage(request, userInfo.getLicencephoto());
					}
					userInfo.setLicencephoto(fileName);
				} else if (photoName != null && photoName.trim().equals("licenceVicePhoto")) {
					// 上传的是驾驶证附页
					if (userInfo.getLicencevicephoto() != null && !userInfo.getLicencevicephoto().equals("")) {
						// 如果原来有图片，那么删除原来的图片
						deleteImage(request, userInfo.getLicencevicephoto());
					}
					userInfo.setLicencevicephoto(fileName);
				}
			}
			userInfoService.updateUserInfo(userInfo); // 更新
			
			response.setContentType("html/text; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.print(fileName);
		}
	}
	
	/**
	 * 保存图片到上传路径的方法
	 * @param request
	 * @param in 图片输入流
	 * @throws Exception
	 * @return 返回文件名
	 */
	public String saveImage(HttpServletRequest request, InputStream in) throws Exception {
		String fileName = UUIDUtils.getUUID() + ".jpg";  // 随机文件名
		String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/uploads") + "/"; // 获得保存路径
		File f = new File(savePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(savePath + fileName);
		int b = 0;
		while ((b = in.read()) != -1) {
			fos.write(b);
		}
		fos.close();
		in.close();
		return fileName;
	}
	
	/**
	 * 异步删除上传的文件
	 * @param response
	 * @param request
	 * @param fileName 文件名
	 * @throws Exception
	 */
	public void deleteImage(HttpServletRequest request, String fileName) throws Exception {
		System.out.println("图片名为：" + fileName);
		String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/uploads") + "/"; // 获得保存路径
		File file = new File(savePath + fileName);
		boolean flag = false;
		if (!file.exists()) {
			System.out.println("文件不存在，无法删除");
		} else {
			if (file.isFile()) {
				flag = file.delete();
			}
		}
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
	
}
