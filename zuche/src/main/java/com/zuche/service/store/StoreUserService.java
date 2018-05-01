package com.zuche.service.store;

import com.zuche.entity.StoreUser;
import com.zuche.entity.User;

/**
 * 门店账号服务接口
 * @author cbl
 *
 */
public interface StoreUserService {

	/**
	 * 保存门店账号
	 * @param storeUser
	 */
	void saveStoreUser(StoreUser storeUser);

	/**
	 * 根据字段查询门店账号
	 * @param fieldValue 字段值
	 * @param fieldName 字段名
	 * @return
	 */
	StoreUser findUserByField(String fieldValue, String fieldName);

	/**
	 * 更新门店账号
	 * @param existStoreUser
	 */
	void updateStoreUser(StoreUser existStoreUser);

	/**
	 * 登陆判断
	 * @param storeUser
	 * @return
	 */
	StoreUser findStoreUser(StoreUser storeUser);
	
}
