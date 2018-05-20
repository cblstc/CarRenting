package com.zuche.service.order;

import java.util.List;

import com.zuche.entity.Orders;
import com.zuche.entity.StoreCar;

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
}
