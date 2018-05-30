package com.zuche.service.order;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.Orders;
import com.zuche.entity.OrdersExample;
import com.zuche.entity.UserExample;
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

	/**
	 * 条件查询订单
	 */
	@Override
	public List<Orders> findOrdersByCondition(Map<String, String> conds) {
		OrdersExample ordersExample = new OrdersExample();
		Criteria criteria = ordersExample.createCriteria();
		
		if (conds != null) {
			for (String fieldName : conds.keySet()) {  // 遍历字段名
				String fieldValue = conds.get(fieldName);  // 获得字段对应的值
				if (fieldName != null) {
					if (fieldName.equals("pageNum")) {
						PageHelper.startPage(Integer.parseInt(fieldValue), 5); // 分页
					}
					if (fieldName.equals("id")) {
						criteria.andIdEqualTo(fieldValue);  // 状态
					}
					if (fieldName.equals("status") && !fieldValue.equals("0")) {
						criteria.andStatusEqualTo(Integer.parseInt(fieldValue));  // 状态
					}
					if (fieldName.equals("userId")) {
						criteria.andUserIdEqualTo(Integer.parseInt(fieldValue));  // id
					}
					if (fieldName.equals("storeCarId")) {
						criteria.andStoreCarIdEqualTo(Integer.parseInt(fieldValue));  // 车辆id
					}
					if (fieldName.equals("storeId")) {
						criteria.andStoreIdEqualTo(Integer.parseInt(fieldValue));  // 门店id
					}
				}
			}
		}
		
		List<Orders> existOrderss = ordersMapper.selectByExample(ordersExample);
		return existOrderss;
	}
}
