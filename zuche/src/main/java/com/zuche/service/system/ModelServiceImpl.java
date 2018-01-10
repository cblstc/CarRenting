package com.zuche.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.Model;
import com.zuche.mapper.ModelMapper;

/**
 * 车型Service实现类
 * @author cbl
 *
 */
@Service
public class ModelServiceImpl implements ModelService {
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * 保存车型
	 */
	@Override
	public void saveModel(Model carModel, String method) {
		if (method.equals("add"))
			modelMapper.insert(carModel);
		else if (method.equals("edit")) {
			modelMapper.updateByPrimaryKey(carModel);
		}
	}

	/**
	 * 查询所有车型
	 */
	@Override
	public List<Model> selectModels() {
		return modelMapper.selectByExample(null);
	}

}
