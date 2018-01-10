package com.zuche.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.Brand;
import com.zuche.mapper.BrandMapper;

/**
 * 品牌Service实现类
 * @author cbl
 *
 */
@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandMapper brandMapper;

	/**
	 * 保存品牌
	 */
	public void saveBrand(Brand brand, String method) {
		if (method.equals("add"))
			brandMapper.insert(brand);
		else if (method.equals("edit")) {
			brandMapper.updateByPrimaryKey(brand);
		}
	}

	@Override
	public List<Brand> selectBrands() {
		return brandMapper.selectByExample(null);
	}

}
