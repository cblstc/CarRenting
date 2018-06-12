package com.zuche.service.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.OrdersComment;
import com.zuche.entity.OrdersCommentExample;
import com.zuche.entity.OrdersCommentExample.Criteria;
import com.zuche.mapper.OrdersCommentMapper;

/**
 * 订单评论service实现类
 * @author cbl
 *
 */
@Service
public class OrdersCommentServiceImpl implements OrdersCommentService {
	
	@Autowired
	private OrdersCommentMapper ordersCommentMapper;

	/**
	 * 保存评论
	 */
	@Override
	public void saveComment(OrdersComment ordersComment) {
		ordersCommentMapper.insert(ordersComment);
	}

	/**
	 * 条件查询订单评论
	 */
	@Override
	public List<OrdersComment> findOrdersCommentByCondition(
			Map<String, String> conds) {
		OrdersCommentExample ordersExample = new OrdersCommentExample();
		Criteria criteria = ordersExample.createCriteria();
		
		if (conds != null) {
			for (String fieldName : conds.keySet()) {  // 遍历字段名
				String fieldValue = conds.get(fieldName);  // 获得字段对应的值
				if (fieldName != null) {
					if (fieldName.equals("pageNum")) {
						PageHelper.startPage(Integer.parseInt(fieldValue), 5); // 分页
					}
					if (fieldName.equals("id")) {
						criteria.andIdEqualTo(new Integer(fieldValue));  // id
					}
					if (fieldName.equals("userId")) {
						criteria.andUserIdEqualTo(Integer.parseInt(fieldValue));  // 用户id
					}
					if (fieldName.equals("ordersId")) {
						criteria.andOrdersIdEqualTo(fieldValue);  // 订单id
					}
				}
			}
		}
		
		List<OrdersComment> existOrdersComments = ordersCommentMapper.selectByExample(ordersExample);
		return existOrdersComments;
	}


}
