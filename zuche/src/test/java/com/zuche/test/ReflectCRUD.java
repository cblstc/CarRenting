package com.zuche.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



public class ReflectCRUD {
	
	private List<Condition> conds = new ArrayList<Condition>();  // 条件
	
	private Class entityClass;  // Xxx.class
	
	private Class exampleClass;  // XxxExample.class
	
	private Object example;  // XxxExample
	 
	private Class criteriaClass;  // Criteria.class
	
	private Object criteria;  // Criteria
	
	public ReflectCRUD(Class entityClass) {
		super();
		this.entityClass = entityClass;
		
		try {
			this.exampleClass = Class.forName(entityClass.getName() + "Example");
			this.criteriaClass = exampleClass.getDeclaredClasses()[0];
			this.example = exampleClass.newInstance();
			Constructor constructor = criteriaClass.getDeclaredConstructors()[0];
			constructor.setAccessible(true);
			this.criteria = constructor.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	public ReflectCRUD() {
		super();
	}
	
	public void addCondition(String fieldName, Object[] args, Integer compare) {
		conds.add(new Condition(fieldName, args, compare));
	}
	
	public Object executeQuery() {
		String regx = null;
		String methodName = null;
		for (Condition cond : conds) {
			String fieldName = cond.getFieldName();
			fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			regx = "and" + fieldName;
			methodName = "and" + fieldName;
			switch (cond.getCompare()) {
			case 1:  // eq
				regx += "[^Or][^Not]EqualTo";
				methodName += "EqualTo";
				break;
			case 2:  // ne
				methodName += "NotEqualTo";
				break;
			case 3:  // gt
				regx += "GreaterThan";
				methodName += "GreaterThan";
				break;
			case 4:  // lt
				regx += "LessThan";
				methodName += "LessThan";
				break;
			case 5:  // ge
				regx += "GreaterThanOrEqualTo";
				methodName += "GreaterThanOrEqualTo";
				break;
			case 6:  // le
				regx += "LessThanOrEqualTo";
				methodName += "LessThanOrEqualTo";
				break;
			case 7:  // like
				regx += "[^Not]Like";
				methodName += "Like";
				break;
			case 8:  // not like
				regx += "NotLike";
				methodName += "NotLike";
				break;
			case 9:  // null
				regx += "IsNull";
				methodName += "IsNull";
				break;
			case 10:  // not null
				regx += "IsNotNull";
				methodName += "IsNotNull";
				break;
			case 11:  // between
				regx += "[^Not]Between";
				methodName += "Between";
				break;
			case 12:  // not between
				regx += "NotBetween";
				methodName += "NotBetween";
				break;
			case 13:  // in
				regx += "[^Not]In";
				methodName += "In";
				break;
			case 14:  // not in
				regx += "NotIn";
				methodName += "NotIn";
				break;
			default:
				break;
			}
			methodInvoke(methodName, cond.getFieldValues());
		}
		
		Method orMethod;
		try {
			orMethod = exampleClass.getDeclaredMethod("or", criteria.getClass());
				orMethod.invoke(example, criteria);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return example;
	}

	/**
	 * 方法匹配
	 * @param clazz
	 */
	/*private void methodInvoke(String regx, Object[] args) {
		Method[] methods = criteriaClass.getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if (isMatches(regx, method.getName())) {
				try {
					method.setAccessible(true);
					criteria = method.invoke(criteria, args);  // 调用相应的方法
					break;
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}*/
	private void methodInvoke(String methodName, Object[] args) {
		Method[] methods = criteriaClass.getMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				try {
					method.setAccessible(true);
					criteria = method.invoke(criteria, args);  // 调用相应的方法
					break;
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 是否匹配
	 * @param regx
	 * @param str
	 * @return
	 */
	/*public static boolean isMatches(String regx, String str) {
		return Pattern.compile(regx).matcher(str).matches();
	}*/
}
