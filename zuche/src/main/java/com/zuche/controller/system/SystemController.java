package com.zuche.controller.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
import com.github.pagehelper.Page;
import com.zuche.entity.User;
import com.zuche.entity.UserInfo;
import com.zuche.intercepter.Token;
import com.zuche.service.system.GarageService;
import com.zuche.service.user.UserInfoService;
import com.zuche.service.user.UserService;
import com.zuche.utils.UUIDUtils;

/**
 * 系统管理controller
 * @author cbl
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private GarageService garageService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param model 
	 * @param pageNum 页数
	 * @param user 用户
	 * @param request
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, Model model, Integer pageNum, User user, Garage garage, HttpServletRequest request) throws Exception {
		if (page.equals("Menu")) {
			return "system/menu";
		} else if (page.equals("UserList")) {
			List<User> users = userService.findUserByCondition(user.getUsername(), user.getPhone(), user.getEmail(), pageNum);
			List<UserUserInfo> userUserInfo = new ArrayList<>();
			for (User u : users) {
				userUserInfo.add(new UserUserInfo(u, userInfoService.findUserInfoByField(u.getId().toString(), "userId")));
			}
			Page<User> usersPage = (Page<User>) users;
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("total", usersPage.getPages() * 5);
			model.addAttribute("userUserInfo", userUserInfo);
			model.addAttribute("username", user.getUsername());
			model.addAttribute("phone", user.getPhone());
			model.addAttribute("email", user.getEmail());
			return "system/userList";
		} else if (page.equals("CarList")) {
			List<Garage> garages = garageService.findCarByCondition(garage.getBrand(), garage.getModel(), garage.getConfiguration(), pageNum);
			Page<Garage> garagesPage = (Page<Garage>) garages;
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("total", garagesPage.getPages() * 5);
			model.addAttribute("garages", garages);
			model.addAttribute("brand", garage.getBrand());
			model.addAttribute("model", garage.getModel());
			model.addAttribute("configuration", garage.getConfiguration());
			System.out.println(garages.size());
			return "system/carList";
		} else {
			return "errorPage";
		}
	}*/
	
	/**
	 * 根据userid获取UserInfo
	 * @param id userId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUserInfoJSON")
	public void getUserInfoJSON(Integer id, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		UserInfo userInfo = userInfoService.findUserInfoByField(id.toString(), "userId");
		response.getWriter().print(JSON.toJSON(userInfo));
	}
	
	/**
	 * 停用用户
	 * @param id 用户id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/stopUser")
	public String stopUser(Integer id) throws Exception {
		User existUser = userService.findUserByField(id.toString(), "id");
		existUser.setStatus(2); // 停用
		userService.updateUser(existUser); 
		return "redirect: toUserList?pageNum=1";
	}
	
	/**
	 * 启用用户
	 * @param id 用户id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/startUser")
	public String startUser(Integer id) throws Exception {
		User existUser = userService.findUserByField(id.toString(), "id");
		existUser.setStatus(1); // 启用
		userService.updateUser(existUser); 
		return "redirect: toUserList?pageNum=1";
	}
	
	/*@RequestMapping(value="/saveGarage", method=RequestMethod.POST)
	public String saveGarage(Garage garage) throws Exception {
		// 设置汽车年份
		String year = garage.getConfiguration().substring(0, 4);
		garage.setYear(new SimpleDateFormat("yyyy").parse(year));
		// 设置汽车图片
		System.out.println("sss:" + garage);
		if (garage != null) {
			if (garage.getId() != null && garage.getId().intValue() != 0) {
				// id存在，执行修改操作
				Garage existGarage = garageService.findById(garage.getId());
				garage.setCarphoto(existGarage.getCarphoto());
				garageService.update(garage);
			} else {
				// id不存在，保存
				garageService.save(garage);
			}
		}
		return "redirect: toCarList?pageNum=1";
	}*/
	
	/**
	 * 异步保存图片
	 * @param model
	 * @param request
	 * @param response
	 * @param file 图片
	 * @param id 车辆id
	 * @throws Exception
	 */
	/*@RequestMapping(value="uploadPhoto",method=RequestMethod.POST)
	public void uploadPhoto(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam("photo") CommonsMultipartFile file,
			Integer id) throws Exception  {
		if (!file.isEmpty()) {
			InputStream in = file.getInputStream();
			String fileName = saveImage(request, in); // 保存图片
			System.out.println(fileName);
			Garage existGarage = garageService.findById(id); // 根据id查询汽车
			System.out.println(existGarage);
			if (existGarage != null) {
				StringBuffer buffer = new StringBuffer(existGarage.getCarphoto());
				if (existGarage.getCarphoto() != null && !existGarage.getCarphoto().equals("")) {
					buffer.append(";");
				}
				buffer.append(fileName);
				existGarage.setCarphoto(buffer.toString());
				garageService.update(existGarage);
				System.out.println("成功" + existGarage.getCarphoto());
			}
			// 保存图片名到数据库
			response.setContentType("html/text; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.print(fileName);
		}
	}*/
	
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
	 * 删除汽车
	 * @param id 汽车id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/removeCar")
	public String removeCar(Integer id) throws Exception {
		/*garageService.removeCar(id);*/
		return "redirect: toCarList?pageNum=1";
	}
}
