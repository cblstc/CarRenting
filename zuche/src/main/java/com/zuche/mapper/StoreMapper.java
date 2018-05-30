package com.zuche.mapper;

import com.zuche.entity.Store;
import com.zuche.entity.StoreDistance;
import com.zuche.entity.StoreExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    int countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreExample example);

    Store selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
    
    /**
     * 查询最近的门店
     * @param latitude
     * @param longtitude
     * @param count
     * @return
     */
    List<StoreDistance> findNearbyStore(Double latitude, Double longitude, int count);
}