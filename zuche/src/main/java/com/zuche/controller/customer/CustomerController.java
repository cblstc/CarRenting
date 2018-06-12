package com.zuche.controller.customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.zuche.entity.Joins;
import com.zuche.entity.Store;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreDistance;
import com.zuche.entity.StoreUser;
import com.zuche.intercepter.Token;
import com.zuche.service.customer.JoinsService;
import com.zuche.service.store.StoreCarService;
import com.zuche.service.store.StoreService;
import com.zuche.service.user.UserService;
import com.zuche.utils.LocationUtils;
import com.zuche.utils.MapValueCompartor;

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
	public String toPage(@PathVariable String page, Model model, HttpServletRequest request, HttpServletResponse response, Integer id, Integer pageNum) throws Exception {
		
		StoreUser storeUser = (StoreUser) request.getSession().getAttribute("storeUser");
		
		System.out.println(storeUser);
		
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
			
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			if (latitude == null || latitude.equals("")) {
				latitude = "23.13";  // 广州的纬度
			}
			if (longitude == null || longitude.equals("")) {
				longitude = "113.27"; // 广州的经度
			}
			
			Store store = null;  // 当前门店
			List<StoreCar> storeCars = null;  // 当前门店下的车辆
			List<StoreDistance> storeDistances = null;  // 当前门店附近的门店
			
			Map<String, String> conds = new HashMap<String, String>();  // 车辆查询条件
			conds.put("status", "1");  // 车辆状态
			
			if (id != null && id.intValue() != 0) {  // 如果门店id不为空，说明用户点击进入了一个门店，那么根据id查询门店
				store = storeService.findStoreByField(id.toString(), "id");
				conds.put("storeId", store.getId().toString());
			} else {  // 如果门店id为空，那么查找最近的一个门店
				storeDistances = storeService.findNearbyStore(Double.parseDouble(latitude), Double.parseDouble(longitude), 11);
				if (storeDistances != null && storeDistances.size() > 0) {
					StoreDistance storeDistance = storeDistances.get(0);
					store = storeService.findStoreByField(storeDistance.getId().toString(), "id");
					conds.put("storeId", storeDistance.getId().toString());
				}
			}
			storeCars = storeCarService.findStoreCarByCondition(conds);
			
			latitude = store.getLatitude().toString();
			longitude = store.getLongitude().toString();
			// 为什么查找11个？因为第一个门店就是自己
			storeDistances = storeService.findNearbyStore(Double.parseDouble(latitude), Double.parseDouble(longitude), 11);
			
			request.getSession().setAttribute("store", store);
			model.addAttribute("storeCars", storeCars);
			model.addAttribute("storeDistances", storeDistances);
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
	
	@RequestMapping(value="/queryNearbyStore")
	public void queryNearbyStore(HttpServletResponse response, Model model, Double latitude, Double longitude) throws Exception {
		System.out.println(latitude + "-" + longitude);
		// Map<Store, Double> storeDistances = new HashMap<Store, Double>();  // 单位：m
//		List<Store> stores = storeService.findStoresByCondition(null);  // 查询所有门店
		List<StoreDistance> storeDistances = storeService.findNearbyStore(latitude, longitude, 10);
		// model.addAttribute("storeDistances", storeDistances);
		/*for (StoreDistance storeDistance : storeDistances) {
			System.out.println(storeDistance.getStorename() + "-" + storeDistance.getDistance() + "m");
		}*/
		/*for (Store store : stores) {
			double distance = LocationUtils.getDistance(21.25746310,110.36506726, store.getLatitude(), store.getLongitude());
			distance = new BigDecimal(distance).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			storeDistances.put(store, distance);
			System.out.println(store.getStorename() + "距离：" + distance + "m");
		}*/
		/*response.setCharacterEncoding("UTF-8"); 
        response.setContentType("application/json; charset=utf-8"); 
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", storeDistances);
        response.getWriter().print(jsonObject);*/
	}
}
