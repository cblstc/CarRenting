package com.zuche.service.system;

import java.util.List;

import com.zuche.entity.Brand;

/**
 * 品牌Service类
 * @author cbl
 *
 */
public interface BrandService {

	/**
	 * 保存品牌
	 * @param brand 品牌
	 * @param method 方法
	 */
	void saveBrand(Brand brand, String method);

	/**
	 * 查询所有品牌
	 * @return
	 */
	List<Brand> selectBrands();

}
