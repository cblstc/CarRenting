package com.zuche.mapper;

import com.zuche.entity.Configuration;
import com.zuche.entity.ConfigurationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigurationMapper {
    int countByExample(ConfigurationExample example);

    int deleteByExample(ConfigurationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Configuration record);

    int insertSelective(Configuration record);

    List<Configuration> selectByExample(ConfigurationExample example);

    Configuration selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Configuration record, @Param("example") ConfigurationExample example);

    int updateByExample(@Param("record") Configuration record, @Param("example") ConfigurationExample example);

    int updateByPrimaryKeySelective(Configuration record);

    int updateByPrimaryKey(Configuration record);
}