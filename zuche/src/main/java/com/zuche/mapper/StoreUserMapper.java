package com.zuche.mapper;

import com.zuche.entity.StoreUser;
import com.zuche.entity.StoreUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreUserMapper {
    int countByExample(StoreUserExample example);

    int deleteByExample(StoreUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreUser record);

    int insertSelective(StoreUser record);

    List<StoreUser> selectByExample(StoreUserExample example);

    StoreUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreUser record, @Param("example") StoreUserExample example);

    int updateByExample(@Param("record") StoreUser record, @Param("example") StoreUserExample example);

    int updateByPrimaryKeySelective(StoreUser record);

    int updateByPrimaryKey(StoreUser record);
}