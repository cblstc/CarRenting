package com.zuche.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zuche.entity.User;
import com.zuche.entity.UserExample;
import com.zuche.entity.UserExample.Criteria;
import com.zuche.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class ReflectTest {
	public static void main(String[] args) throws Exception, SecurityException {
		/*List<Condition> conds = new ArrayList<Condition>();
		conds.add(new Condition("username", new Object[] {"cblstc"}, Condition.EQ));
		ReflectCRUD<User> reflectCRUD = new ReflectCRUD<User>(User.class, conds);
		List<User> list = reflectCRUD.executeQuery();*/
		Class<UserExample> userExampleClass = UserExample.class;
		Field field = userExampleClass.getDeclaredField("oredCriteria");
		Method method = userExampleClass.getDeclaredMethod(
				"selectByExample", userExampleClass.getClass());
		System.out.println(method.getName());
	}
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test() throws Exception {
		/*List<Condition> conds = new ArrayList<Condition>();
		conds.add(new Condition("username", new Object[] {"cblstc"}, Condition.EQ));
		ReflectCRUD<User> reflectCRUD = new ReflectCRUD<User>(User.class, conds);
		List<User> list = reflectCRUD.executeQuery();*/
		/*Class empClazz = UserExample.class;
		Object empClass = empClazz.newInstance();
		Class crtClazz = empClazz.getDeclaredClasses()[0];
		Method method = crtClazz.getDeclaredMethod("andUsernameEqualTo", String.class);
		method.setAccessible(true);
		Constructor constructor = crtClazz.getDeclaredConstructors()[0];
		constructor.setAccessible(true);
		Criteria criteria = (Criteria) method.invoke(constructor.newInstance(), new Object[]{"cblstc"});
		
		Method orMethod = empClazz.getDeclaredMethod("or", Criteria.class);
		orMethod.invoke(empClass, criteria);
		List<User> users = userMapper.selectByExample((UserExample) empClass);
		System.out.println(users.size());*/
		
		
	}
	
	@Test
	public void test2() throws Exception {
		ReflectCRUD reflectCRUD = new ReflectCRUD(User.class);
		reflectCRUD.addCondition("email", new Object[] {"%.net%"}, Condition.LIKE);
		reflectCRUD.addCondition("id", new Object[] {30,60}, Condition.BETWEEN);
		UserExample example = (UserExample) reflectCRUD.executeQuery();
		List<User> users = userMapper.selectByExample(example);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test3() throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailLike("%.net%");
		criteria.andIdBetween(30, 60);
		List<User> users = userMapper.selectByExample(example);
		for (User user : users) {
			System.out.println(user);
		}
	}
}
