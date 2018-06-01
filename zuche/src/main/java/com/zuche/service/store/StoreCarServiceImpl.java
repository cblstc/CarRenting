package com.zuche.service.store;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreCarExample;
import com.zuche.entity.StoreCarExample.Criteria;
import com.zuche.mapper.StoreCarMapper;

/**
 * 门店车库服务类
 * @author cbl
 *
 */
@Service
public class StoreCarServiceImpl implements StoreCarService {
	
	@Autowired
	private StoreCarMapper storeCarMapper;

	/**
	 * 条件查询
	 */
	@Override
	public List<StoreCar> findCarByCondition(String brand, String model,
			String configuration, Integer storeId, Integer pageNum) {
		// 分页
//		PageHelper.startPage(pageNum, 5);
		
		StoreCarExample storeCarExample = new StoreCarExample();
		Criteria criteria = storeCarExample.createCriteria();
		
		if (brand != null && !brand.trim().equals("") && !brand.trim().equals("0")) {
			criteria.andBrandEqualTo(brand);
		} 
		if (model != null && !model.trim().equals("") && !model.trim().equals("0")) {
			criteria.andModelEqualTo(model);
		} 
		if (configuration != null && !configuration.trim().equals("") && !configuration.trim().equals("0")) {
			criteria.andConfigurationEqualTo(configuration);
		}
		if (storeId != null && storeId.intValue() != 0) {
			criteria.andStoreIdEqualTo(storeId);
		} 
		
		List<StoreCar> existCars = storeCarMapper.selectByExample(storeCarExample);
		return existCars;
	}

	/**
	 * 根据字段查询
	 */
	@Override
	public List<StoreCar> findCarByField(String fieldValue, String fieldName) {
		StoreCarExample storeCarExample = new StoreCarExample();
		Criteria criteria = storeCarExample.createCriteria();
		
		if (fieldName.equals("brand")) {
			criteria.andBrandEqualTo(fieldValue);
		} else if (fieldName.equals("id")) {
			criteria.andIdEqualTo(new Integer(fieldValue));
		} else if (fieldName.equals("storeId")) {
			criteria.andStoreIdEqualTo(new Integer(fieldValue));
		}
		
		List<StoreCar> existCars = storeCarMapper.selectByExample(storeCarExample);
		return existCars;
	}
	
	/**
	 * 保存车辆信息
	 * @param storeCar 车辆信息
	 */
	@Override
	public void saveCar(StoreCar storeCar) {
		storeCarMapper.insert(storeCar);  // 插入一条记录
	}
	
	/**
	 * 更新车辆信息
	 * @param storeCar 车辆信息
	 */
	@Override
	public void updateCar(StoreCar storeCar) {
		storeCarMapper.updateByPrimaryKey(storeCar);  
	}
	
	/**
	 * 条件查询车辆
	 */
	@Override
	public List<StoreCar> findStoreCarByCondition(Map<String, String> conds) {
		StoreCarExample storeCarExample = new StoreCarExample();
		Criteria criteria = storeCarExample.createCriteria();
		
		if (conds != null) {
			for (String fieldName : conds.keySet()) {  // 遍历字段名
				String fieldValue = conds.get(fieldName);  // 获得字段对应的值
				if (fieldName != null) {
					if (fieldName.equals("pageNum")) {
						PageHelper.startPage(Integer.parseInt(fieldValue), 5); // 分页
					}
					if (fieldName.equals("id")) {
						criteria.andIdEqualTo(new Integer(fieldValue));  // id
					}
					if (fieldName.equals("storeId")) {
						criteria.andStoreIdEqualTo(Integer.parseInt(fieldValue));  // 门店id
					}
					if (fieldName.equals("brand")) {
						criteria.andBrandEqualTo(fieldValue);  // 车辆品牌
					}
					if (fieldName.equals("model")) {
						criteria.andModelEqualTo(fieldValue);  // 车辆型号
					}
					if (fieldName.equals("configuration")) {
						criteria.andConfigurationEqualTo(fieldValue);  // 车辆配置
					}
					if (fieldName.equals("status")) {
						criteria.andStatusEqualTo(Integer.parseInt(fieldValue));  // 车辆状态
					}
				}
			}
		}
		
		List<StoreCar> existCars = storeCarMapper.selectByExample(storeCarExample);
		return existCars;
	}
}
