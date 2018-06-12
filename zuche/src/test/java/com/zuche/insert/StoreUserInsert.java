package com.zuche.insert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuche.entity.StoreUser;
import com.zuche.mapper.StoreUserMapper;
import com.zuche.random.RandomUser;
import com.zuche.utils.MD5Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })
public class StoreUserInsert {
	
	@Autowired
	private StoreUserMapper storeUserMapper;
	
	@Test
	public void insertStoreUser() throws Exception {
		
		for (int i = 0; i < 100; i++) {
			StoreUser storeUser = new StoreUser();
			storeUser.setUsername(RandomUser.getUsername((int) (Math.random() * 6 + 8)));
			storeUser.setPassword(MD5Utils.getMD5Str(RandomUser.getPassword((int) (Math.random() * 6 + 8))));
			storeUser.setStatus((int) (Math.random() * 2 + 1));
			storeUserMapper.insert(storeUser);
		}
	}
}
