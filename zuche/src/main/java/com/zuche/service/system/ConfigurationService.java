package com.zuche.service.system;

import java.util.List;

import com.zuche.entity.Configuration;

/**
 * 车辆配置service接口
 * @author cbl
 *
 */
public interface ConfigurationService {

	/**
	 * 保存配置信息
	 * @param configuration 车辆配置
	 * @param method
	 */
	void saveConfiguration(Configuration configuration, String method);

	/**
	 * 查找所有的配置
	 * @return
	 */
	List<Configuration> selectConfigurations();

}
