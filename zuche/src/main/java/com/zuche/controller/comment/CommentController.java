package com.zuche.controller.comment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.zuche.entity.Orders;
import com.zuche.entity.OrdersComment;
import com.zuche.entity.Store;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreComment;
import com.zuche.service.comment.OrdersCommentService;
import com.zuche.service.comment.StoreCommentService;
import com.zuche.service.order.OrdersService;
import com.zuche.service.store.StoreCarService;
import com.zuche.service.store.StoreService;


/**
 * 评论控制类
 * @author cbl
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreCarService storeCarService;
	
	@Autowired
	private OrdersCommentService ordersCommentService;
	
	@Autowired
	private StoreCommentService storeCommentService;
	
	/**
	 * 保存评论
	 * @param ordersComment
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveComment")
	public String saveComment(OrdersComment ordersComment) throws Exception {
		Map<String,String> conds = new HashMap<String,String>();
		conds.put("id", ordersComment.getOrdersId());
		List<Orders> orderss = ordersService.findOrdersByCondition(conds);  // 查询订单
		Orders orders = null;
		if (orderss != null && orderss.size() > 0) {
			orders = orderss.get(0);
			orders.setStatus(7);  // 订单完成
			ordersService.updateOrders(orders);  // 更新状态
		}
		
		ordersComment.setTime(new Date());
		ordersComment.setStoreId(orders.getStoreId());  // 门店id
		ordersComment.setStoreCarId(orders.getStoreCarId());  // 门店车辆id
		ordersCommentService.saveComment(ordersComment);  // 保存评论
		
		List<StoreCar> storeCars = storeCarService.findCarByField(ordersComment.getStoreCarId().toString(), "id");
		if (storeCars != null && storeCars.size() > 0) {
			StoreCar storeCar = storeCars.get(0);
			Integer totalStar = storeCar.getTotalstar() + ordersComment.getStar();  // 总评分数
			Integer totalComment = storeCar.getTotalcomment() + 1;  // 总评论数
			Double avgStar = totalStar / (totalComment * 1.0);  // 平均分
			
			storeCar.setTotalstar(totalStar);
			storeCar.setTotalcomment(totalComment);
			storeCar.setAvgstar(new BigDecimal(avgStar).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()); 
			
			storeCarService.updateCar(storeCar);  // 更新
		}
		
		return "redirect:/user/toOrdersList";
	}
	
	@RequestMapping("/saveStoreComment")
	public String saveStoreComment(StoreComment storeComment) throws Exception {
		
		storeComment.setTime(new Date());
		storeCommentService.saveComment(storeComment);  // 保存评论
		
		Store store = storeService.findStoreByField(storeComment.getStoreId().toString(), "id");
		Integer totalStar = store.getTotalstar() + storeComment.getStar();  // 总评分数
		Integer totalComment = store.getTotalcomment() + 1;  // 总评论数
		Double avgStar = totalStar / (totalComment * 1.0);  // 平均分
		
		store.setTotalstar(totalStar);
		store.setTotalcomment(totalComment);
		store.setAvgstar(new BigDecimal(avgStar).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());  
		
		storeService.updateStore(store);  // 更新门店
		
		return "redirect:/toCarList?id=" + storeComment.getStoreId();
	}
	
	/**
	 * 查看评论
	 * @param ordersComment
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/showComment")
	public void showComment(OrdersComment ordersComment, HttpServletResponse response) throws Exception {
		Map<String,String> conds = new HashMap<String,String>();
		conds.put("userId", ordersComment.getUserId().toString());
		conds.put("ordersId", ordersComment.getOrdersId());
		List<OrdersComment> ordersComments = ordersCommentService.findOrdersCommentByCondition(conds);  // 查询评论
		if (ordersComments != null && ordersComments.size() > 0) {
			OrdersComment existOrdersComment= ordersComments.get(0);
			
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", existOrdersComment);
			response.getWriter().print(jsonObject);
		}
	}
}
