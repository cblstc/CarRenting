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

import org.apache.commons.lang3.RandomStringUtils;
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
import com.zuche.entity.Joins;
import com.zuche.entity.StoreUser;
import com.zuche.entity.User;
import com.zuche.entity.UserAndInfo;
import com.zuche.entity.UserInfo;
import com.zuche.intercepter.Token;
import com.zuche.service.customer.JoinsService;
import com.zuche.service.store.StoreUserService;
import com.zuche.service.system.GarageService;
import com.zuche.service.user.UserInfoService;
import com.zuche.service.user.UserService;
import com.zuche.utils.MD5Utils;
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
	private JoinsService joinsService;
	
	@Autowired
	private StoreUserService storeUserService;
	
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
	@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, Model model, Integer pageNum, User user, Joins joins, HttpServletRequest request) throws Exception {
		if (page.equals("Menu")) {
			return "system/menu";
		} else if (page.equals("UserList")) {
			List<User> users = userService.findUserByCondition(user.getUsername(), user.getPhone(), user.getEmail(), pageNum);
			List<UserAndInfo> userAndInfos = new ArrayList<UserAndInfo>();
			for (User u : users) {
				userAndInfos.add(new UserAndInfo(u, userInfoService.findUserInfoByField(u.getId().toString(), "userId")));
			}
			Page<User> usersPage = (Page<User>) users;
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("total", usersPage.getPages() * 5);
			model.addAttribute("userAndInfos", userAndInfos);
			model.addAttribute("username", user.getUsername());
			model.addAttribute("phone", user.getPhone());
			model.addAttribute("email", user.getEmail());
			return "system/userList";
		} else if (page.equals("JoinsList")) {
			List<Joins> joinss = joinsService.findJoinsByCondition(joins.getName(), joins.getPhone(), joins.getStatus(), pageNum);
			Page<Joins> JoinssPage = (Page<Joins>) joinss;
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("total", JoinssPage.getPages() * 5);
			model.addAttribute("joinss", joinss);
			model.addAttribute("name", joins.getName());
			model.addAttribute("phone", joins.getPhone());
			model.addAttribute("status", joins.getStatus());
			return "system/joinsList";
		}  else {
			return "errorPage";
		}
	}
	
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
	
	/**
	 * 通过申请
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/passJoins")
	public String passJoins(Integer id) throws Exception {
		Joins existJoins = joinsService.findJoinsByField(id.toString(), "id");
		existJoins.setStatus(2); // 申请通过
		joinsService.updateJoins(existJoins);
		
		if (existJoins.getStoreUserId() != null && existJoins.getStoreUserId().intValue() != 0) {
			// 如果该申请人已经拥有门店账号，那么门店账号开启
			joinsService.sendPass(existJoins.getEmail());  // 发送邮件给申请人
			// 开启门店账号
			StoreUser existStoreUser = storeUserService.findUserByField(
					existJoins.getStoreUserId().toString(), "id");
			existStoreUser.setStatus(1);  // 开启门店账号
			storeUserService.updateStoreUser(existStoreUser);
		} else {
			// 创建一个随机账号
			String username = UUIDUtils.getUUID().substring(0, 8);
			String password = UUIDUtils.getUUID().substring(0, 8);
			// 发送账号给申请人
			joinsService.sendAccount(username, password, existJoins.getEmail());  
			// 保存账号
			StoreUser storeUser = new StoreUser();
			storeUser.setUsername(username);
			storeUser.setPassword(MD5Utils.getMD5Str(password));
			storeUserService.saveStoreUser(storeUser);
			// 绑定账号和加盟申请
			StoreUser existStoreUser = storeUserService.findUserByField(username, "username");
			existJoins.setStoreUserId(existStoreUser.getId());
			joinsService.updateJoins(existJoins);
		}
		
		return "redirect: toJoinsList?pageNum=1";
	}
	
	/**
	 * 拒绝申请
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/failJoins")
	public String failJoins(Integer id) throws Exception {
		Joins existJoins = joinsService.findJoinsByField(id.toString(), "id");
		existJoins.setStatus(3); // 拒绝申请
		joinsService.updateJoins(existJoins);
		// 发送拒绝信
		joinsService.sendFail(existJoins.getEmail());
		return "redirect: toJoinsList?pageNum=1";
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
