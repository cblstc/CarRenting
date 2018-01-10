package com.zuche.service.system;

import java.util.List;

import com.zuche.entity.Configuration;
import com.zuche.entity.Model;

/**
 * 车型service
 * @author cbl
 *
 */
public interface ModelService {

	/**
	 * 保存车型
	 * @param carModel 车型
	 * @param method
	 */
	void saveModel(com.zuche.entity.Model carModel, String method);

	/**
	 * 查询所有车型
	 * @return
	 */
	List<Model> selectModels();

}
