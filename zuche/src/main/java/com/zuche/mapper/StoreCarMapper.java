package com.zuche.mapper;

import com.zuche.entity.StoreCar;
import com.zuche.entity.StoreCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreCarMapper {
    int countByExample(StoreCarExample example);

    int deleteByExample(StoreCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreCar record);

    int insertSelective(StoreCar record);

    List<StoreCar> selectByExample(StoreCarExample example);

    StoreCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreCar record, @Param("example") StoreCarExample example);

    int updateByExample(@Param("record") StoreCar record, @Param("example") StoreCarExample example);

    int updateByPrimaryKeySelective(StoreCar record);

    int updateByPrimaryKey(StoreCar record);
}