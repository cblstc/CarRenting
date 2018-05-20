package com.zuche.test;

public class Condition {
	private String fieldName;  // 字段名
	private Object[] fieldValues; // 字段值
	private Integer compare; // 比较方式
	/* 常量 */
	public static final Integer EQ = 1;  // 等于
	public static final Integer NE = 2; // 不等于
	public static final Integer GT = 3;
	public static final Integer LT = 4;
	public static final Integer GE = 5;
	public static final Integer LE = 6;
	public static final Integer LIKE = 7;
	public static final Integer N_LIKE = 8;
	public static final Integer NULL = 9;
	public static final Integer N_NULL = 10;
	public static final Integer BETWEEN = 11;
	public static final Integer N_BETWEEN = 12;
	public static final Integer IN = 13;
	public static final Integer N_IN = 14;
	
	/**
	 * 条件构造
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @param compare 比较方式
	 */
	public Condition(String fieldName, Object[] fieldValues, Integer compare) {
		super();
		this.fieldName = fieldName;
		this.fieldValues = fieldValues;
		this.compare = compare;
	}

	public Condition() {
		super();
	}


	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object[] getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(Object[] fieldValues) {
		this.fieldValues = fieldValues;
	}

	public Integer getCompare() {
		return compare;
	}

	public void setCompare(Integer compare) {
		this.compare = compare;
	}

}