package com.zuche.service.store;

import com.zuche.entity.StoreCar;

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

}
