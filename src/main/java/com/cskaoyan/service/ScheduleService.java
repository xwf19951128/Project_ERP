package com.cskaoyan.service;

import com.cskaoyan.bean.schedule.*;

import java.util.List;

public interface ScheduleService {


    List<Custom> queryCustomListByPage(Integer page, Integer rows);

    SchedulList<Order> queryOrderListByPage(Integer page, Integer rows);

    List<Product> queryProductListByPage(Integer page, Integer rows);

    List<Work> queryWorkListByPage(Integer page, Integer rows);

    List<Manufacture> queryManufactureByPage(Integer page, Integer rows);

    List<Task> queryTaskByPage(Integer page, Integer rows);

    SchedulList<Order> searchOrderListByID(Integer searchValue, Integer page, Integer rows);

    Custom queryCustomByID(Integer id);

    Product queryProductByID(Integer pid);
    List<Order> queryOrders();

    int updateCustom(Custom custom);

    int updateInfo(Custom custom);
    int updateInfo(Product product);

    int updateOrder(Order order);

    int updateInfo(Manufacture manufacture);
    int updateInfo(Task task);
    int updateInfo(Work work);
    int updateInfo(Order order);

    List<Custom> queryCustoms();

    List<Product> queryProducts();

    int insertOrder(Order order);

    int deleteOrderByID(String id);

    int deletepathByOid(String oid);
}
