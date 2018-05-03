package com.zuche.utils;

import java.lang.reflect.Method;

import com.zuche.entity.UserExample;

public class ReflectTest {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class userClass = UserExample.class;
		Class criteraClass = userClass.getDeclaredClasses()[0];
		Method[] methods = criteraClass.getMethods();
		for (Method method : methods) {
			// 对方法进行分类
			System.out.println(method.getName() + method.getParameterTypes());  // 获得所有方法名
		}
	}
}
