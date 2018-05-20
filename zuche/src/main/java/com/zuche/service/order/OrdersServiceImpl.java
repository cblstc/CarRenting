package com.zuche.service.order;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.Orders;
import com.zuche.entity.OrdersExample;
import com.zuche.entity.OrdersExample.Criteria;
import com.zuche.entity.User;
import com.zuche.mapper.OrdersMapper;
import com.zuche.utils.MD5Utils;

/**
 * 订单service实现类
 * @author cbl
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;

	/**
	 * 保存用户
	 */
	public void saveOrders(Orders orders) {
		ordersMapper.insert(orders);
	}

	/**
	 * 根据字段查询
	 */
	@Override
	public List<Orders> findOrdersByField(String fieldValue, String fieldName) {
		OrdersExample ordersExample = new OrdersExample();
		Criteria criteria = ordersExample.createCriteria();
		
		if (fieldName.equals("id")) {
			criteria.andIdEqualTo(fieldValue);
		} else if (fieldName.equals("status")) {
			criteria.andStatusEqualTo(new Integer(fieldValue));
		}
		
		List<Orders> existOrderss = ordersMapper.selectByExample(ordersExample);
		return existOrderss;
	}

	/**
	 * 更新订单
	 */
	@Override
	public void updateOrders(Orders orders) {
		ordersMapper.updateByPrimaryKey(orders);
	}
}
