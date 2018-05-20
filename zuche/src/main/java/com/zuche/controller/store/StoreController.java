package com.zuche.controller.store;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.zuche.entity.Store;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreUser;
import com.zuche.entity.StoreUserAndStore;
import com.zuche.intercepter.Token;
import com.zuche.service.store.StoreCarService;
import com.zuche.service.store.StoreService;
import com.zuche.service.store.StoreUserService;
import com.zuche.utils.UUIDUtils;

/**
 * 门店控制类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreUserService storeUserService;
	
	@Autowired
	private StoreCarService storeCarService;
	
	/**
	 * 页面跳转
	 * @param page 跳转的页面
	 * @param request
	 * @param model
	 * @param operate 方法：如edit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/to{page}")
	@Token(save=true)
	public String toPage(@PathVariable String page, HttpServletRequest request, Model model, String operate, StoreCar storeCar, Integer pageNum) throws Exception {
		
		StoreUser storeUser = (StoreUser) request.getSession().getAttribute("storeUser");
		
		String result = null;
		
		switch (page) {
		case "Login":  /* 登陆 */
			result = "store/login";
			break;
		case "Index":  /* 首页 */
			result = "store/index";
			
			/* 判断门店用户是否已经填写门店信息 */
			if (storeUser != null) {
				Store existStore = storeService.findStoreByField(storeUser.getId().toString(), "storeUserId");
				if (existStore == null) {  // 门店不存在
					model.addAttribute("isNew", "isNew");
				}
			}
			
			break;
		case "StoreInfo":  /* 门店信息 */
			result = "store/storeInfo";
			
			if (operate != null && operate.equals("edit")) {  // 如果是编辑页面，那么保存request域
				if (storeUser != null) {
					Store existStore = storeService.findStoreByField(storeUser.getId().toString(), "storeUserId");
					model.addAttribute("store", existStore);
				}
			}
			
			break;
		case "CarList":  /* 汽车列表 */
			List<StoreCar> storeCars = storeCarService.findCarByCondition(storeCar.getBrand(), storeCar.getModel(), 
					storeCar.getConfiguration(), pageNum);
			Page<StoreCar> storeCarsPage = (Page<StoreCar>) storeCars;
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("total", storeCarsPage.getPages() * 5);
			model.addAttribute("storeCars", storeCars);
			model.addAttribute("brand", storeCar.getBrand());
			model.addAttribute("model", storeCar.getModel());
			model.addAttribute("configuration", storeCar.getConfiguration());
			
			result = "store/carList";
			break;
		case "EditCar":  /* 编辑车辆 */
			result = "store/editCar";
			
			if (operate != null && operate.equals("edit")) {  // 如果是编辑页面，那么保存request域
				List<StoreCar> existStoreCars = storeCarService.findCarByField(
						storeCar.getId().toString(),"id");
				if (existStoreCars != null && existStoreCars.size() > 0) {
					StoreCar existStoreCar = existStoreCars.get(0);
					model.addAttribute("storeCar", existStoreCar);
				}
			}
			
			break;
		case "OrdersList":  /* 订单列表 */
			result = "store/ordersList";
			break;
		case "OrdersCommentList":  /* 订单评论列表 */
			result = "store/ordersCommentList";
			break;
		case "AddCar":  /* 添加车辆 */
			result = "store/article-add";
			break;
		default:  /* 错误页面 */
			result = "errorPage";
			break;
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/uploads", method=RequestMethod.POST)
	public void uploads(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") CommonsMultipartFile file) throws Exception {
		if (file != null) {
			String fileName = saveImage(request, file.getInputStream()); // 保存图片
			
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("fileName", fileName);
			response.getWriter().print(jsonObject);
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
		System.out.println(fileName);
		return fileName;
	}
	
	@RequestMapping(value="/saveCar", method=RequestMethod.POST)
	public String saveCar(StoreCar storeCar, HttpServletRequest request) throws Exception {
		
		StoreUser storeUser = (StoreUser) request.getSession().getAttribute("storeUser");
		Store existStore = storeService.findStoreByField(storeUser.getId().toString(), "storeUserId"); 
		
		if (storeCar != null) {
			storeCar.setStoreId(existStore.getId());  // 设置门店id
			storeCar.setStatus(1);   // 设置上架
			
			if (storeCar.getId() == null) {  // 保存
				storeCarService.saveCar(storeCar);  // 保存车辆信息
			} else {  // 更新
				List<StoreCar> existStoreCars = storeCarService.findCarByField(
						storeCar.getId().toString(),"id");
				if (existStoreCars != null && existStoreCars.size() > 0) {
					StoreCar existStoreCar = existStoreCars.get(0);
					storeCarService.updateCar(storeCar); // 更新车辆信息
				}
			}
		}
		
		return "redirect:/store/toCarList?pageNum=1";
	}
	
	
	@RequestMapping(value="/saveStoreInfo", method=RequestMethod.POST)
	public String saveStoreInfo(Store store, String startTime, String endTime, HttpServletRequest request) throws Exception {
		StoreUser storeUser = (StoreUser) request.getSession().getAttribute("storeUser");

		store.setStarttime(new SimpleDateFormat("HH:mm").parse(startTime));
		store.setEndtime(new SimpleDateFormat("HH:mm").parse(endTime));
		store.setStoreUserId(storeUser.getId());
		
		if (store.getId() != null && store.getId().intValue() != 0) {  // 更新
			Store existStore = storeService.findStoreByField(store.getId().toString(), "id");
			store.setAvgstar(existStore.getAvgstar()); // 评分
			store.setTotalstar(existStore.getTotalstar());  // 总星星
			store.setTotalcomment(existStore.getTotalcomment());  // 总评论数
			store.setStatus(existStore.getStatus());   // 设置开启门店
			storeService.updateStoreInfo(store);  // 更新门店信息
		} else {  // 保存
			store.setAvgstar(0.0f); // 评分
			store.setTotalstar(0);  // 总星星
			store.setTotalcomment(0);  // 总评论数
			store.setStatus(1);   // 设置开启门店
			storeService.saveStoreInfo(store);  // 保存门店信息
		}
		return "redirect:/store/toIndex";
	}
	
	/**
	 * 登陆
	 * @param storeUser
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	@Token(remove=true)
	public String login(StoreUser storeUser, HttpServletRequest request, Model model) throws Exception {
		// 查询是否存在
		StoreUser existStoreUser = storeUserService.findStoreUser(storeUser);  // 登陆判断
		if (existStoreUser == null) {
			model.addAttribute("loginError", "账户或密码错误");
			return "forward:/store/toLogin";  // 账户或密码错误
		} else if (existStoreUser.getStatus().intValue() == 2) {
			model.addAttribute("loginError", "账户被冻结");
			return "forward:/store/toLogin";  // 账户被冻结
		} else {
			request.getSession().setAttribute("storeUser", existStoreUser);
			return "redirect:/store/toIndex";
		}
	}
	
	@RequestMapping("/changeStatus")
	public String changeStatus(Integer id, String operate) throws Exception {
		if (operate != null && operate.equals("carUp")) { // 上架
			if (id != null) {
				List<StoreCar> existStoreCars = storeCarService.findCarByField(
						id.toString(),"id");
				if (existStoreCars != null && existStoreCars.size() > 0) {
					StoreCar existCar = existStoreCars.get(0);
					existCar.setStatus(1);
					storeCarService.updateCar(existCar);
				}
			}
		} else if (operate != null && operate.equals("carDown")) { // 下架
			if (id != null) {
				List<StoreCar> existStoreCars = storeCarService.findCarByField(
						id.toString(),"id");
				if (existStoreCars != null && existStoreCars.size() > 0) {
					StoreCar existCar = existStoreCars.get(0);
					existCar.setStatus(2);
					storeCarService.updateCar(existCar);
				}
			}
		}
		
		return "redirect:/store/toCarList?pageNum=1";
	}
}
