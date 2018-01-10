package com.zuche.mapper;

import com.zuche.entity.UserCar;
import com.zuche.entity.UserCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCarMapper {
    int countByExample(UserCarExample example);

    int deleteByExample(UserCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCar record);

    int insertSelective(UserCar record);

    List<UserCar> selectByExampleWithBLOBs(UserCarExample example);

    List<UserCar> selectByExample(UserCarExample example);

    UserCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCar record, @Param("example") UserCarExample example);

    int updateByExampleWithBLOBs(@Param("record") UserCar record, @Param("example") UserCarExample example);

    int updateByExample(@Param("record") UserCar record, @Param("example") UserCarExample example);

    int updateByPrimaryKeySelective(UserCar record);

    int updateByPrimaryKeyWithBLOBs(UserCar record);

    int updateByPrimaryKey(UserCar record);
}