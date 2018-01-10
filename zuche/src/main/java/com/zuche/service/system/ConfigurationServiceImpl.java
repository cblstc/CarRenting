package com.zuche.service.system;

import java.util.List;

import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuche.entity.Configuration;
import com.zuche.mapper.ConfigurationMapper;

/**
 * 车辆配置service实现类
 * @author cbl
 *
 */
@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	
	@Autowired
	private ConfigurationMapper configurationMapper;

	/**
	 * 保存配置信息
	 */
	@Override
	public void saveConfiguration(Configuration configuration, String method) {
		if (method.equals("add"))
			configurationMapper.insert(configuration);
		else if (method.equals("edit")) {
			configurationMapper.updateByPrimaryKey(configuration);
		}
	}

	/**
	 * 查找所有的配置信息
	 */
	@Override
	public List<Configuration> selectConfigurations() {
		return configurationMapper.selectByExample(null);
	}

}
