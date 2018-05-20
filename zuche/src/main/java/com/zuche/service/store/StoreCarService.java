package com.zuche.service.store;

import java.util.List;

import com.zuche.entity.StoreCar;

/**
 * 门店车库服务接口
 * @author cbl
 *
 */
public interface StoreCarService {

	/**
	 * 条件查询
	 * @param brand 品牌
	 * @param model 型号
	 * @param configuration 配置 
	 * @param pageNum 页数
	 * @return
	 */
	List<StoreCar> findCarByCondition(String brand, String model,
			String configuration, Integer pageNum);

	/**
	 * 根据字段查询
	 * @param fieldValue 字段值
	 * @param fieldName 字段名
	 * @return
	 */
	List<StoreCar> findCarByField(String fieldValue, String fieldName);

	/**
	 * 保存车辆信息
	 * @param storeCar 车辆信息
	 */
	void saveCar(StoreCar storeCar);
	
	/**
	 * 更新车辆信息
	 * @param storeCar 车辆信息
	 */
	void updateCar(StoreCar storeCar);
}
