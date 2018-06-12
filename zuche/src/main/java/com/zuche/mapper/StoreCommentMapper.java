package com.zuche.mapper;

import com.zuche.entity.StoreComment;
import com.zuche.entity.StoreCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreCommentMapper {
    int countByExample(StoreCommentExample example);

    int deleteByExample(StoreCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreComment record);

    int insertSelective(StoreComment record);

    List<StoreComment> selectByExample(StoreCommentExample example);

    StoreComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreComment record, @Param("example") StoreCommentExample example);

    int updateByExample(@Param("record") StoreComment record, @Param("example") StoreCommentExample example);

    int updateByPrimaryKeySelective(StoreComment record);

    int updateByPrimaryKey(StoreComment record);
}