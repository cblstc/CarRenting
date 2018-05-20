package com.zuche.insert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuche.entity.Store;
import com.zuche.mapper.OrdersMapper;
import com.zuche.mapper.StoreMapper;
import com.zuche.random.RandomStore;
import com.zuche.random.RandomUser;
import com.zuche.service.order.OrdersService;
import com.zuche.utils.LocationUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class OrderInsert {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrdersService ordersService;
	
	@Test
	public void insertStore() throws Exception {
		System.out.println(ordersMapper + "," + ordersService);
	}

}
