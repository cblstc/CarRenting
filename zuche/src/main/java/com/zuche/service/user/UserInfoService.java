package com.zuche.service.user;

import com.zuche.entity.UserInfo;

/**
 * 用户信息service接口
 * @author cbl
 *
 */
public interface UserInfoService {

	/**
	 * 保存用户信息
	 * @param userInfo 用户信息
	 */
	void saveUserInfo(UserInfo userInfo);

	/**
	 * 更新用户信息
	 * @param userInfo 用户信息
	 */
	void updateUserInfo(UserInfo userInfo);

	/**
	 * 根据字段获取用户信息
	 * @param fieldValue 字段值
	 * @param fieldName 字段名
	 * @return
	 */
	UserInfo findUserInfoByField(String fieldValue, String fieldName);
}
