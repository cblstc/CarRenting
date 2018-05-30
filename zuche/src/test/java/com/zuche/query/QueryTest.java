package com.zuche.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuche.entity.StoreUser;
import com.zuche.service.store.StoreUserService;
import com.zuche.utils.LocationUtils;
import com.zuche.utils.MD5Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class QueryTest {
	
	@Autowired
	private StoreUserService storeUserService;
	
	@Test
	public void queryStoreUser() throws Exception {
		StoreUser storeUser = storeUserService.findUserByField(new Integer(123).toString(), "id");
		System.out.println();
	}
	
	@Test
	public void queryStore() throws Exception {
	}
}
