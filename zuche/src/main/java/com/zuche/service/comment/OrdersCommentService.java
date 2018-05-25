package com.zuche.service.comment;

import java.util.List;
import java.util.Map;

import com.zuche.entity.Orders;
import com.zuche.entity.OrdersComment;

/**
 * 订单评论service接口
 * @author cbl
 *
 */
public interface OrdersCommentService {

	/**
	 * 保存评论
	 * @param ordersComment 
	 */
	void saveComment(OrdersComment ordersComment);

	/**
	 * 条件查询订单评论
	 * @param conds
	 * @return
	 */
	List<OrdersComment> findOrdersCommentByCondition(Map<String, String> conds);

}
