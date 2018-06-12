package com.zuche.service.system;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 汽车Service实现类
 * @author cbl
 *
 */
@Service
public class GarageServiceImpl implements GarageService {
	/*

	*//**
	 * 条件查询汽车
	 *//*
	@Override
	public List<Garage> findCarByCondition(String brand, String model,
			String configuration, Integer pageNum) {
		// 分页
		PageHelper.startPage(pageNum, 5);
		
		GarageExample garageExample = new GarageExample();
		Criteria criteria = garageExample.createCriteria();
		if (brand != null && !brand.trim().equals("")) {
			criteria.andBrandLike("%" + brand + "%");
		} else if (model != null && !model.trim().equals("")) {
			criteria.andModelLike("%" + model + "%");
		} else if (configuration != null && !configuration.trim().equals("")) {
			criteria.andConfigurationLike("%" + configuration + "%");
		}
		List<Garage> garages = garageMapper.selectByExample(garageExample);
		return garages;
	}

	*//**
	 * 更新车库
	 *//*
	@Override
	public void update(Garage garage) {
		garageMapper.updateByPrimaryKey(garage);
	}

	*//**
	 * 保存车库
	 *//*
	@Override
	public void save(Garage garage) {
		garageMapper.insert(garage);
	}

	*//**
	 * 删除汽车
	 *//*
	@Override
	public void removeCar(Integer id) {
		garageMapper.deleteByPrimaryKey(id);
	}

	*//**
	 * 根据id查询汽车
	 *//*
	@Override
	public Garage findById(Integer id) {
		return garageMapper.selectByPrimaryKey(id);
	}
	*/
}
