package com.cskaoyan.mapper.schedule;

import com.cskaoyan.bean.schedule.Custom;
import com.cskaoyan.bean.schedule.Order;
import com.cskaoyan.bean.schedule.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(@Param("oid") String orderId);

    int insert(@Param("record") Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(@Param("record") Order record);

    int updateOrderAll(@Param("record") Order record);

    Long queryOrderCount();

    List<Order> queryPage(@Param("page") int page, @Param("row") int rows);

    List<Order> queryOrders();

    Custom queryCustomByID(@Param("id") Integer id);

    Product queryProductByID(@Param("id") Integer pid);
    int updateCustom(@Param("custom") Custom custom);

    List<Custom> queryCustoms();

    List<Product> queryProducts();

    int deletepathByOid(@Param("oid") String oid);
}