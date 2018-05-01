package com.zuche.mapper;

import com.zuche.entity.OrdersComment;
import com.zuche.entity.OrdersCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersCommentMapper {
    int countByExample(OrdersCommentExample example);

    int deleteByExample(OrdersCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrdersComment record);

    int insertSelective(OrdersComment record);

    List<OrdersComment> selectByExample(OrdersCommentExample example);

    OrdersComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrdersComment record, @Param("example") OrdersCommentExample example);

    int updateByExample(@Param("record") OrdersComment record, @Param("example") OrdersCommentExample example);

    int updateByPrimaryKeySelective(OrdersComment record);

    int updateByPrimaryKey(OrdersComment record);
}