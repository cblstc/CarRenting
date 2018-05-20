package com.zuche.insert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuche.entity.User;
import com.zuche.mapper.UserMapper;
import com.zuche.random.RandomUser;
import com.zuche.utils.MD5Utils;
import com.zuche.utils.UUIDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class UserInsert {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void insert() {
		for (int i=0; i<100; i++) {
			String phone = RandomUser.getTel();
			String username = RandomUser.getUsername((int) (Math.random() * 6 + 8));  // 6-12
			String email = RandomUser.getEmail(5, 30);
			String password = RandomUser.getPassword((int) (Math.random() * 6 + 8));  // 6-12
			Integer role = (int) (Math.random() * 2 + 1);
			Integer status = (int) (Math.random() * 2 + 1);
			Date date = RandomUser.getRegistTime("2014-01-01", "2018-01-01");
			User user = new User();
			user.setUsername(username);
			user.setPassword(MD5Utils.getMD5Str(password));
			user.setRegisttime(date);
			user.setStatus(status);
			user.setRole(role);
			user.setEmail(email);
			user.setPhone(phone);
			
			// 插入n条数据
			userMapper.insert(user);
//			System.out.println("Phone: " +  phone + ",username: " + username + ",email: " + email + ",password: " +  password + ",role: " + role + ",status: " + status + ",date: " +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).toString());
		}
	}
}
