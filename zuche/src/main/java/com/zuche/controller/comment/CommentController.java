package com.zuche.controller.comment;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.zuche.entity.Orders;
import com.zuche.entity.OrdersComment;
import com.zuche.service.comment.OrdersCommentService;
import com.zuche.service.comment.StoreCommentService;
import com.zuche.service.order.OrdersService;


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
		ordersComment.setTime(new Date());
		ordersCommentService.saveComment(ordersComment);  // 保存评论
		
		Map<String,String> conds = new HashMap<String,String>();
		conds.put("id", ordersComment.getOrdersId());
		List<Orders> orderss = ordersService.findOrdersByCondition(conds);  // 查询订单
		if (orderss != null && orderss.size() > 0) {
			Orders orders= orderss.get(0);
			orders.setStatus(7);  // 订单完成
			ordersService.updateOrders(orders);  // 更新状态
		}
		return "redirect:/user/toOrdersList";
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
		conds.put("orderId", ordersComment.getOrdersId());
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
