package com.zuche.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.StoreCar;
import com.zuche.mapper.StoreCarMapper;

/**
 * 门店service实现类
 * @author cbl
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreCarMapper storeCarMapper;

	/**
	 * 保存车辆信息
	 * @param storeCar 车辆信息
	 */
	@Override
	public void saveCar(StoreCar storeCar) {
		storeCarMapper.insert(storeCar);  // 插入一条记录
	}

}
