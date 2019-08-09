package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Long queryOrderCount();

    List<Order> queryPage(@Param("page") int page, @Param("row") int rows);

    List<Order> queryOrders();

    Custom queryCustomByID(@Param("id") Integer id);

    Product queryProductByID(@Param("id") Integer pid);
}