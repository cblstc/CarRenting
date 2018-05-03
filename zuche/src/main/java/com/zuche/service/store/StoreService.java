package com.zuche.service.store;

import java.util.List;

import com.zuche.entity.Store;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreUser;

/**
 * 门店service类
 * @author cbl
 *
 */
public interface StoreService {

	/**
	 * 保存车辆信息
	 * @param storeCar 车辆信息
	 */
	void saveCar(StoreCar storeCar);

	/**
	 * 条件查询
	 * @param storename 门店名称
	 * @param address 门店地址
	 * @param phone 门店联系电话
	 * @param pageNum 页码
	 * @return
	 */
	List<Store> findStoreByCondition(String storename, String address,
			String phone, Integer pageNum);

	/**
	 * 根据某个字段查询
	 * @param fieldValue 字段值
	 * @param fieldName 字段名
	 * @return
	 */
	Store findStoreByField(String fieldValue, String fieldName);

	/**
	 * 更新门店
	 * @param existStore
	 */
	void updateStore(Store existStore);

	/**
	 * 保存门店信息
	 * @param store
	 */
	void saveStoreInfo(Store store);

	/**
	 * 更新门店信息
	 * @param store
	 */
	void updateStoreInfo(Store store);

}
