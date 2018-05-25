package com.zuche.service.order;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.Orders;
import com.zuche.entity.StoreCar;
import com.zuche.entity.User;
import com.zuche.entity.UserExample;
import com.zuche.entity.UserExample.Criteria;

/**
 * 订单service接口
 * @author cbl
 *
 */
public interface OrdersService {

	/**
	 * 保存订单
	 * @param orders
	 */
	public void saveOrders(Orders orders);
	
	/**
	 * 根据字段查询
	 * @param fieldValue 字段值
	 * @param fieldName 字段名
	 * @return
	 */
	List<Orders> findOrdersByField(String fieldValue, String fieldName);

	/**
	 * 更新订单
	 * @param orders
	 */
	public void updateOrders(Orders orders);
	
	/**
	 * 条件查询订单
	 */
	public List<Orders> findOrdersByCondition(Map<String, String> conds);
}
